package com.hdfc.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.utility.CalculatePremiumLocators;
import com.hdfc.utility.Constant;

/**
 * The Class BuyPlanHelper.
 */
public class BuyPlanHelper implements CalculatePremiumLocators {
    /** The Constant logger. */
    final static Logger logger = Logger.getLogger( BuyPlanHelper.class );

    /** The wait. */
    private static WebDriverWait wait;

    /** The driver. */
    private static WebDriver driver;

    /**
     * Instantiates a new buy plan helper.
     *
     * @param wait the wait
     * @param driver the driver
     */
    @SuppressWarnings ( "static-access" )
    public BuyPlanHelper( WebDriverWait wait, WebDriver driver ) {
        this.wait = wait;
        this.driver = driver;
    }

    /**
     * Handle multiple windows.
     */
    public void handleMultipleWindows() {
        String parentWindow = driver.getWindowHandle();
        Set<String> numberOfWindows = driver.getWindowHandles();
        if ( numberOfWindows.size() <= 1 )
            logger.debug( "No Multiple Windows Identified, continue filling personal details" );
        else {
            for ( String window : numberOfWindows ) {
                if ( !(window.equals( parentWindow )) ) {
                    driver.switchTo().window( window );
                }
            }
        }
    }

    /**
     * Handle NRI button.
     */
    public void handleNRIButton() {
        wait.until( ExpectedConditions.visibilityOfElementLocated( NRI_NO ) );
        driver.findElement( NRI_NO ).click();
        logger.debug( "CLICKED NRI NO IMAGE" );
    }

    /**
     * Handle gender button.
     */
    public void handleGenderButton() {
        driver.findElement( femaleImage ).click();
        logger.debug( "CLICKED FEMALE GENDER IMAGE" );
    }

    /**
     * Handle first name.
     */
    public void handleFirstName() {
        driver.findElement( firstName ).sendKeys( Constant.FIRST_NAME );
        logger.debug( "FIRSTNAME ENTERED " + Constant.FIRST_NAME );
    }

    /**
     * Handle last name.
     */
    public void handleLastName() {
        driver.findElement( lastName ).sendKeys( Constant.LAST_NAME );
        logger.debug( "LASTNAME ENTERED " + Constant.LAST_NAME );
    }

    /**
     * Handle mobile number.
     */
    public void handleMobileNumber() {
        driver.findElement( mobileNumber ).sendKeys( Constant.MOBILE_NUMBER );
        logger.debug( "MOBILE ENTERED" );
    }

    /**
     * Handle email id.
     */
    public void handleEmailId() {
        driver.findElement( emailID ).sendKeys( Constant.EMAIL );
        logger.debug( "EMAIL ENTERED" );
    }

    /**
     * Handle DOB.
     */
    public void handleDOB() {
        driver.findElement( DOB ).click();
        wait.until( ExpectedConditions.visibilityOfElementLocated( calendar ) );

        WebElement month = driver.findElement( monthInCalendar );
        while ( true ) {
            try {
                if ( !month.getText().equals( Constant.DOB_MONTH ) ) {
                    driver.findElement( nextMonth_Btn ).click();
                    Thread.sleep( 500 );
                    month = driver.findElement( monthInCalendar );
                } else {
                    break;
                }
            } catch ( InterruptedException e ) {
                logger.debug( "Unable to communicate with Calendar" );
            }
        }

        driver.findElement( setBtnInCalendar ).click();
        logger.debug( "DOB ENTERED" );
    }

    /**
     * Handle tobacco user.
     */
    public void handleTobaccoUser() {
        wait.until( ExpectedConditions.elementToBeClickable( tobaccoUserSmoke ) );
        driver.findElement( tobaccoUserSmoke ).click();
        logger.debug( "CLICKED TOBACCO SMOKE IMAGE" );
    }

    /**
     * Handle pincode.
     */
    public void handlePincode() {
        driver.findElement( pincode ).sendKeys( Constant.PIN_CODE );
        logger.debug( "PIN ENTERED" );
    }

    /**
     * Handle city.
     *
     * @throws AWTException the AWT exception
     */
    public void handleCity() throws AWTException {
        driver.findElement( city ).clear();
        wait.until( ExpectedConditions.elementToBeClickable( city ) );
        driver.findElement( city ).sendKeys( Constant.CITY );
        Robot rob = new Robot();
        rob.keyPress( KeyEvent.VK_DOWN );
        rob.keyPress( KeyEvent.VK_ENTER );
        logger.debug( "CITY ENTERED" );
    }

    /**
     * Handle state.
     */
    public void handleState() {
        wait.until( ExpectedConditions.elementToBeClickable( state ) );
        new Select( driver.findElement( state ) ).selectByVisibleText( Constant.STATE );
        logger.debug( "STATE ENTERED" );
    }

    /**
     * Click proceed btn.
     */
    public void clickProceedBtn() {
        wait.until( ExpectedConditions.elementToBeClickable( proceed_Btn ) );
        driver.findElement( proceed_Btn ).click();
        logger.debug( "CLICKED PROCEED BUTTON" );
    }

    /**
     * Close browser.
     */
    public void closeBrowser() {
        driver.quit();
        logger.debug( "BROWSER CLOSED..." );
    }

    /**
     * Handdle buy insurance online.
     */
    public void handdleBuyInsuranceOnline() {
        if ( driver.getTitle().contains( Constant.TITLE_LIFE_INSURANCE_PLANS ) ) {
            wait.until( ExpectedConditions.elementToBeClickable( buyOnline_Btn ) );
            driver.findElement( buyOnline_Btn ).click();
        } else {
            logger.debug( "Unable to interact with Buy Online button on Homepage... CLOSING BROWSER" );
            closeBrowser();
        }
    }

    /**
     * Launch browser.
     */
    public void launchBrowser() {
        logger.debug( "LAUNCHING BROWSER..." );
        driver.get( Constant.URL );
    }

}
