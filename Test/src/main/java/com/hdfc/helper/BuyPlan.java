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
        logger.debug( "LAUNCHING BROWSER..." );
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
            logger.debug( "Unable to interact with Buy Online button on Homepage... CLOSING BROWSER" );
            closeHDFCLife();
        }
    }

    /**
     * Buy HDFC life protection plans.
     * @throws InterruptedException 
     * @throws AWTException 
     *
     * @description This method will select a Protection Plan and click on Calculate button
     */
    public void buyHDFCLifeProtectionPlans() throws InterruptedException, AWTException {
        WebDriver driver = DriverUtil.getDriver();
        if ( driver.getTitle().contains( "Buy Online Life Insurance Policy, Health Plans, Pension Plans, ULIP & Investment Plan - HDFC Life" ) ) {
            wait.until( ExpectedConditions.elementToBeClickable( combiProtectionPlan_dropDown ) );
            new Select( driver.findElement( combiProtectionPlan_dropDown ) ).selectByVisibleText( "Click 2 Protect Health - Combi Plan" );
            WebElement calculate = driver.findElement( combiProtectionCalculate_Btn );
            wait.until( ExpectedConditions.visibilityOf( calculate ) );
            calculate.click();
            enterPersonalDetails( driver );
        } else {
            logger.debug( "Unable to select Protection Plan on Insurance page... CLOSING BROWSER" );
            closeHDFCLife();
        }
    }

    /**
     * Enter personal details.
     *
     * @param driver the driver
     * @throws InterruptedException 
     * @throws AWTException 
     * @description
     */
    public void enterPersonalDetails( WebDriver driver ) throws InterruptedException, AWTException {

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
        wait.until( ExpectedConditions.visibilityOfElementLocated( NRI_NO ) );
        driver.findElement( NRI_NO ).click();
        logger.debug( "CLICKED NRI NO IMAGE" );
        
        driver.findElement( femaleImage ).click();
        logger.debug( "CLICKED FEMALE GENDER IMAGE" );
        
        driver.findElement( firstName ).sendKeys( "Ishwar" );
        logger.debug( "FIRSTNAME ENTERED" );
        
        driver.findElement( lastName ).sendKeys( "Sukhani" );
        logger.debug( "LASTNAME ENTERED" );
        
        driver.findElement( mobileNumber ).sendKeys( "9021345678" );
        logger.debug( "MOBILE ENTERED" );
        
        driver.findElement( emailID ).sendKeys( "ishwar.sukhani@hdfc.com" );
        logger.debug( "EMAIL ENTERED" );

        driver.findElement( DOB ).click();
        wait.until( ExpectedConditions.visibilityOfElementLocated( calendar ) );

        WebElement month = driver.findElement( monthInCalendar );
        while ( true ) {
            if (!month.getText().equals( "Sep" ) ) {
                driver.findElement( nextMonth_Btn ).click();
                Thread.sleep( 500 );
                month = driver.findElement( monthInCalendar );
            } 
            else {
                break;
            }
        }
        
        driver.findElement( setBtnInCalendar ).click();
        logger.debug( "DOB ENTERED" );
 /*       
        wait.until( ExpectedConditions.visibilityOfElementLocated( dayInCalendar ) );
        List<WebElement> days = driver.findElements( dayInCalendar );
        if(days.size() > 1){
            for(WebElement element : days){
                if(element.isEnabled() && element.getAttribute( "textContent" ).contains( "14" )) 
                    element.click();
            }
        }
*/
         wait.until( ExpectedConditions.elementToBeClickable( tobaccoUserSmoke ) );
         driver.findElement( tobaccoUserSmoke ).click();
         logger.debug( "CLICKED TOBACCO SMOKE IMAGE" );
         
         driver.findElement( pincode ).sendKeys( "400708" );
         logger.debug( "PIN ENTERED" );
         
         driver.findElement( city ).clear(); 
         wait.until(ExpectedConditions.elementToBeClickable(city));
         driver.findElement( city ).sendKeys( "Mumbai" );
         Robot rob = new Robot();
         rob.keyPress( KeyEvent.VK_DOWN );
         rob.keyPress( KeyEvent.VK_ENTER );
         logger.debug( "CITY ENTERED" );
         
         wait.until( ExpectedConditions.elementToBeClickable( state ) ); 
         new Select( driver.findElement( state )).selectByVisibleText( "Maharashtra" );
         logger.debug( "STATE ENTERED" );
 /*         
         wait.until( ExpectedConditions.elementToBeClickable( authorize_Chkbox ) );
         driver.findElement( authorize_Chkbox ).click();
         logger.debug( "CLICKED AUTHORIZE CHECKBOX" );
 */        
         wait.until( ExpectedConditions.elementToBeClickable( proceed_Btn ) );
         driver.findElement( proceed_Btn ).click();
         logger.debug( "CLICKED PROCEED BUTTON" );
    }

    /**
     * Close HDFC life.
     */
    public void closeHDFCLife() {
        DriverUtil.getDriver().quit();
        logger.debug( "BROWSER CLOSED..." );
    }
}
