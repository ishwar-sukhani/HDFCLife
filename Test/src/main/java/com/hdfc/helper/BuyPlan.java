package com.hdfc.helper;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.utility.CalculatePremiumLocators;
import com.hdfc.utility.Constant;
import com.hdfc.utility.DriverUtil;

/**
 * The Class BuyPlan.
 */
public class BuyPlan implements CalculatePremiumLocators {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger( BuyPlan.class );

    /** The wait. */
    private static WebDriverWait wait;

    /**
     * Instantiates a new buy plan.
     *
     * @description Constructor to initialize Explicit wait object
     */
    public BuyPlan() {
        wait = new WebDriverWait( DriverUtil.getDriver(), Constant.MAX_WAIT_TIME );
    }

    /**
     * Open HDFC life.
     *
     * @description This method opens URL in browser window
     */
    public void openHDFCLife() {
        DriverUtil.getDriver().get( Constant.URL );
    }

    /**
     * Buy insurance online.
     *
     * @description This method will click Buy Online button on HDFC Life homepage
     */
    public void buyInsuranceOnline() {
        if ( DriverUtil.getDriver().getTitle().contains( "HDFC Life Insurance - Life Insurance Plans and Policies in India" ) ) {
            wait.until( ExpectedConditions.elementToBeClickable( buyOnline_Btn ) );
            DriverUtil.getDriver().findElement( buyOnline_Btn ).click();
        } else {
            System.out.println( "Unable to interact with Buy Online button on Homepage... CLOSING BROWSER" );
            closeHDFCLife();
        }
    }

    /**
     * Buy HDFC life protection plans.
     *
     * @description This method will select a Protection Plan and click on Calculate button
     */
    public void buyHDFCLifeProtectionPlans() {
        WebDriver driver = DriverUtil.getDriver();
        if ( driver.getTitle().contains( "Buy Online Life Insurance Policy, Health Plans, Pension Plans, ULIP & Investment Plan - HDFC Life" ) ) {
            wait.until( ExpectedConditions.elementToBeClickable( combiProtectionPlan_dropDown ) );
            new Select( driver.findElement( combiProtectionPlan_dropDown ) ).selectByVisibleText( "Click 2 Protect Health - Combi Plan" );
            WebElement calculate = driver.findElement( combiProtectionCalculate_Btn );
            wait.until( ExpectedConditions.visibilityOf( calculate ) );
            calculate.click();
            enterPersonalDetails( driver );
        } else {
            System.out.println( "Unable to select Protection Plan on Insurance page... CLOSING BROWSER" );
            closeHDFCLife();
        }
    }

    /**
     * Enter personal details.
     *
     * @param driver the driver
     * @description
     */
    public void enterPersonalDetails( WebDriver driver ) {

        String parentWindow = driver.getWindowHandle();
        Set<String> numberOfWindows = driver.getWindowHandles();
        if ( numberOfWindows.size() <= 1 )
            System.out.println( "No Multiple Windows Identified, continue filling personal details" );
        else {
            for ( String window : numberOfWindows ) {
                if ( !(window.equals( parentWindow )) ) {
                    driver.switchTo().window( window );
                }
            }
        }
        wait.until( ExpectedConditions.visibilityOfElementLocated( NRI_NO ) );
        driver.findElement( NRI_NO ).click();
        driver.findElement( femaleImage ).click();
        driver.findElement( firstName ).sendKeys( "Ishwar" );
        driver.findElement( lastName ).sendKeys( "Sukhani" );
        driver.findElement( mobileNumber ).sendKeys( "9021345678" );
        driver.findElement( emailID ).sendKeys( "ishwar.sukhani@hdfc.com" );

        driver.findElement( tobaccoUserSmoke ).click();
        System.out.println( "CLICKED TOBACCO" );

        driver.findElement( pincode ).sendKeys( "400708" );
        System.out.println( "PIN ENTERED" );
        logger.debug( "PIN ENTERED" );

        // wait.until(ExpectedConditions.visibilityOfElementLocated(city));
        driver.findElement( city ).clear();
        driver.findElement( city ).sendKeys( "Mumbai" );
        System.out.println( "CITY ENTERED" );
        logger.debug( "CITY ENTERED" );

        wait.until( ExpectedConditions.elementToBeClickable( state ) );
        new Select( driver.findElement( state ) ).selectByVisibleText( "Maharashtra" );
        System.out.println( "STATE ENTERED" );
        logger.debug( "STATE ENTERED" );

        driver.findElement( DOB ).click();
        wait.until( ExpectedConditions.visibilityOfElementLocated ( calendar ) );

        wait.until( ExpectedConditions.visibilityOfElementLocated( authorize_Chkbox ) );
        driver.findElement( authorize_Chkbox );
        driver.findElement( proceed_Btn );
    }

    /**
     * Close HDFC life.
     */
    public void closeHDFCLife() {
        DriverUtil.getDriver().quit();
        logger.debug( "BROWSER CLOSED..." );
    }
}
