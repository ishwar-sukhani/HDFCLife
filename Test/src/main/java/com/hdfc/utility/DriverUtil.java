package com.hdfc.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * The Class DriverUtil.
 */
public class DriverUtil {

    /** The driver. */
    private static WebDriver driver;

    static {

        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--disable-notifications" );
        System.setProperty( "webdriver.chrome.driver", Constant.CHROME_DRIVER_PATH );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
    }

    /**
     * Gets the driver.
     *
     * @return the driver
     */
    public static WebDriver getDriver() {
        return driver;
    }
}
