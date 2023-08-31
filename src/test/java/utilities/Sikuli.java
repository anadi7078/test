package utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import runner.MyTestRunner;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Sikuli extends KeywordUtil {
    static String basePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\ImageData\\";


    public static void verifyThatSharePopupIsVisible() throws IOException, FindFailed, InterruptedException, UnsupportedFlavorException, FindFailed {
        Thread.sleep(5000);
        Screen s = new Screen();
        Pattern sharePopup = new Pattern(basePath + "profile2.png");
        boolean flag = false;
        s.wait(sharePopup);
        if (s.exists(sharePopup) != null)
            flag = true;
        else
            flag = false;
        Assert.assertTrue("popup not found", flag);

        ScreenImage screenshot = s.capture();
        if (System.getProperty("screen_shot") != null && System.getProperty("screen_shot").equalsIgnoreCase("true")) {
            String path = screenshot.getFilename();
            InputStream is = new FileInputStream(path);
            byte[] imageBytes = org.apache.commons.compress.utils.IOUtils.toByteArray(is);
            Thread.sleep(2000);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            String pathForLogger = MyTestRunner.logger.addBase64ScreenShot("data:image/png;base64," + base64);
            MyTestRunner.logger.log(LogStatus.PASS,
                    HTMLReportUtil.infoStringGreenColor(pathForLogger));

        } else {
            if (ConfigReader.getValue("screenshotFlag").equalsIgnoreCase("true")) {
                String path = screenshot.getFilename();
                InputStream is = new FileInputStream(path);
                byte[] imageBytes = org.apache.commons.compress.utils.IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                String pathForLogger = MyTestRunner.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                MyTestRunner.logger.log(LogStatus.PASS,
                        HTMLReportUtil.infoStringGreenColor(pathForLogger));
            }

        }
        MyTestRunner.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("native share popup is visible"));
        //Closing the pop-up
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void takeDesktopScreenshot() {
        try {
            Screen s = new Screen();
            ScreenImage screenshot = s.capture();
            if (System.getProperty("screen_shot") != null && System.getProperty("screen_shot").equalsIgnoreCase("true")) {
                String path = screenshot.getFilename();
                InputStream is = new FileInputStream(path);
                byte[] imageBytes = org.apache.commons.compress.utils.IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                String pathForLogger = MyTestRunner.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                MyTestRunner.logger.log(LogStatus.PASS,
                        HTMLReportUtil.infoStringGreenColor(pathForLogger));

            } else {
                if (ConfigReader.getValue("screenshotFlag").equalsIgnoreCase("true")) {
                    String path = screenshot.getFilename();
                    InputStream is = new FileInputStream(path);
                    byte[] imageBytes = org.apache.commons.compress.utils.IOUtils.toByteArray(is);
                    Thread.sleep(2000);
                    String base64 = Base64.getEncoder().encodeToString(imageBytes);
                    String pathForLogger = MyTestRunner.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                    MyTestRunner.logger.log(LogStatus.PASS,
                            HTMLReportUtil.infoStringGreenColor(pathForLogger));
                }

            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}


