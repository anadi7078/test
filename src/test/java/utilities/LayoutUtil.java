package utilities;

import com.google.common.collect.ImmutableMap;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import mobileutil.MobileKeywords;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import org.json.JSONArray;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import runner.MyTestRunner;

import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class LayoutUtil {


    public static void checkLogUsingBrowserMob(String url) {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\mehak.malhotra\\Documents\\GitHub\\SNA2\\src\\test\\resources\\chromedriver116.exe");
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start();

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Assert.fail("invalid Host Address");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--headless");
        options.addArguments("window-size=1440,784");
        options.merge(capabilities);

        options.addArguments("--ignore-certificate-errors");

//        options.setCapability(CapabilityType.PROXY, proxy);
        WebDriver driver = new ChromeDriver(options);
        proxy.newHar();
        driver.get(url);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List<HarEntry> entries = proxy.getHar().getLog().getEntries();
        Boolean status = false;
        for (HarEntry entry : entries) {
            if ((entry.getRequest().getUrl().contains(".css")) || entry.getRequest().getUrl().contains("/images")) {
                System.out.println("URL " + entry.getRequest().getUrl());
                System.out.println("Response Code " + entry.getResponse().getStatus());
                if (entry.getResponse().getStatus() == 200) {
                    status = true;
                } else {
                    MyTestRunner.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("the layout is broken for the current page due to URL : " + entry
                            .getRequest().getUrl() + " giving response code as " + entry.getResponse().getStatus()));
                    status = false;
                }
                Assert.assertTrue(status);


            }

        }

        proxy.stop();
        driver.close();
        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the layout is not broken for the current page"));

    }


    public static void checkLogUsingBrowserMobForMobileBrowser(String pageURL) {
        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("MobileDetails", "android device");
        String deviceDetails = dataMap.get("Device Details");
        String deviceName = deviceDetails.split("_")[0];
        String osVersion = deviceDetails.split("_")[1];
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, osVersion);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileKeywords.GetValue("platformName"));
        capabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir") + "/src/test/resources/chromedriver116.exe");
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capabilities.setCapability("enablePerformanceLogging", true);
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.merge(capabilities);
        options.addArguments("--ignore-certificate-errors");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new AndroidDriver<AndroidElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(pageURL);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return JSON.stringify(network);";
        String netData = ((JavascriptExecutor) driver).executeScript(scriptToExecute).toString();
        JSONArray array = new JSONArray(netData);
        for (int i = 0; i < array.length(); i++) {
            dataMap = new HashMap<>();
            System.out.println(array);
            if ((array.getJSONObject(i).get("name").toString().contains("devacademy.sna.tv")) && (array.getJSONObject(i).get("name").toString().contains(".css"))) {
//                dataMap.put("API",array.getJSONObject(i).get("name").toString());
                System.out.println(array.getJSONObject(i).get("name").toString());
//                dataMap.put("Status",array.getJSONObject(i).get("responseStatus").toString());
                System.out.println(array.getJSONObject(i).get("responseStatus").toString());
                Assert.assertEquals(array.getJSONObject(i).get("responseStatus"), 200);

            }

            if ((array.getJSONObject(i).get("name").toString().contains("devacademy.sna.tv")) && (array.getJSONObject(i).get("name").toString().contains("/images"))) {
                dataMap.put("API", array.getJSONObject(i).get("name").toString());
                System.out.println(array.getJSONObject(i).get("name").toString());
                dataMap.put("Status", array.getJSONObject(i).get("responseStatus").toString());
                System.out.println(array.getJSONObject(i).get("responseStatus").toString());
                Assert.assertEquals(array.getJSONObject(i).get("responseStatus"), 200);
            }
        }
        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the layout is not broken for the current page"));
        driver.close();

    }

    public static void checkLogUsingBrowserMobFireFox(String url) {
        WebDriverManager.firefoxdriver().setup();
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true);
        proxy.start();

        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Assert.fail("invalid Host Address");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        FirefoxProfile ffprofile = new FirefoxProfile();
        ffprofile.setPreference("dom.webnotifications.enabled", false);
        ffprofile.setPreference("dom.push.enabled", false);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--headless");
        options.addArguments("window-size=1440,784");
        options.setProfile(ffprofile);
        options.merge(capabilities);


//        options.setCapability(CapabilityType.PROXY, proxy);
        WebDriver driver = new FirefoxDriver(options);
        proxy.newHar();
        driver.get(url);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List<HarEntry> entries = proxy.getHar().getLog().getEntries();
        Boolean status = false;
        for (HarEntry entry : entries) {
            if ((entry.getRequest().getUrl().contains(".css")) || entry.getRequest().getUrl().contains("/images")) {
                System.out.println("URL " + entry.getRequest().getUrl());
                System.out.println("Response Code " + entry.getResponse().getStatus());
                if (entry.getResponse().getStatus() == 200) {
                    status = true;
                } else {
                    MyTestRunner.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("the layout is broken for the current page due to URL : " + entry
                            .getRequest().getUrl() + " giving response code as " + entry.getResponse().getStatus()));
                    status = false;
                }
                Assert.assertTrue(status);


            }

        }

        proxy.stop();
        driver.close();
        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("the layout is not broken for the current page"));

    }
}
