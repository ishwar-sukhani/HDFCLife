package com.hdfc.bl;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hdfc.helper.BuyPlanHelper;
import com.hdfc.locators.BuyPlanLocators;
import com.hdfc.utility.Constant;
import com.hdfc.utility.DriverUtil;

/**
 * The Class BuyPlan.
 */
public class BuyPlan implements BuyPlanLocators {

    /** The Constant logger. */
    final static Logger logger = Logger.getLogger( BuyPlan.class );

    /** The wait. */
    private static WebDriverWait wait;

    /** The buy plan helper. */
    private BuyPlanHelper buyPlanHelper;

    /**
     * Instantiates a new buy plan.
     *
     * @description Constructor to initialize Explicit wait object
     */
    public BuyPlan() {
        wait = new WebDriverWait( DriverUtil.getDriver(), Constant.MAX_WAIT_TIME );
        buyPlanHelper = new BuyPlanHelper( wait, DriverUtil.getDriver() );

    }

    /**
     * Open HDFC life.
     *
     * @description This method opens URL in browser window
     */
    public void openHDFCLife() {
        buyPlanHelper.launchBrowser();
    }

    /**
     * Buy insurance online.
     *
     * @description This method will click Buy Online button on HDFC Life homepage
     */
    public void buyInsuranceOnline() {
        buyPlanHelper.handdleBuyInsuranceOnline();
    }

    /**
     * Buy HDFC life protection plans.
     *
     * @throws InterruptedException the interrupted exception
     * @throws AWTException the AWT exception
     * @description This method will select a Protection Plan and click on Calculate button
     */
    public void buyHDFCLifeProtectionPlans() throws InterruptedException, AWTException {
        logger.debug( "Opening other page.. please wait" );
        WebDriver driver = DriverUtil.getDriver();
        if ( driver.getTitle().contains( Constant.TITLE_ULIP_PLANS ) ) {
            wait.until( ExpectedConditions.elementToBeClickable( combiProtectionPlan_dropDown ) );
            new Select( driver.findElement( combiProtectionPlan_dropDown ) ).selectByVisibleText( Constant.TITLE_COMBI_PLANS );
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
     * @throws AWTException the AWT exception
     * @description
     */
    public void enterPersonalDetails( WebDriver driver ) throws AWTException {

        buyPlanHelper.handleMultipleWindows();

        buyPlanHelper.handleNRIButton();

        buyPlanHelper.handleGenderButton();

        buyPlanHelper.handleFirstName();

        buyPlanHelper.handleLastName();

        buyPlanHelper.handleMobileNumber();
        
        buyPlanHelper.handleEmailId();

        buyPlanHelper.handleDOB();

        buyPlanHelper.handleTobaccoUser();

        buyPlanHelper.handlePincode();

        buyPlanHelper.handleCity();

        buyPlanHelper.handleState();

        buyPlanHelper.clickProceedBtn();

    }

    /**
     * Close HDFC life.
     */
    public void closeHDFCLife() {
        buyPlanHelper.closeBrowser();
    }
}
