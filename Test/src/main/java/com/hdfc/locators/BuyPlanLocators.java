package com.hdfc.locators;

import org.openqa.selenium.By;

/**
 * The Interface BuyPlanLocators.
 */
public interface BuyPlanLocators {

    /** The buy online btn. */
    // Locators of HomePage
    By buyOnline_Btn = By.xpath( "//a[@class='tnt-sticky-btn']" );

    /** The combi protection plan drop down. */
    // Locators of Insurance page
    By combiProtectionPlan_dropDown = By.xpath( "//*[@id='s2id_autogen3']/following::select" );

    /** The combi protection calculate btn. */
    By combiProtectionCalculate_Btn = By.xpath( "//*[@id='s2id_autogen3']/following::a[@class='calculateAnchor opt-1-2']" );

    /** The nri no. */
    // Locators of Insurance Form page
    By NRI_NO = By.xpath( "//input[@id='btnNo']/following::label" );

    /** The male image. */
    By maleImage = By.xpath( "//*[@id='personaldtls']//div[@class='selCircle']/input[@id='malegender']/following::label" );

    /** The female image. */
    By femaleImage = By.xpath( "//*[@id='personaldtls']//div[@class='selCircle']/input[@id='femalegender']/following::label" );

    /** The first name. */
    By firstName = By.xpath( "//*[@id='Nri_No']//div[@class='customInput']/input[@id='fName']" );

    /** The last name. */
    By lastName = By.xpath( "//*[@id='Nri_No']//div[@class='customInput']/input[@id='lName']" );

    /** The mobile number. */
    By mobileNumber = By.xpath( "//input[@id='mobile']" );

    /** The email ID. */
    By emailID = By.xpath( "//*[@id='personaldtls']//div//input[@id='emailID']" );

    /** The dob. */
    By DOB = By.xpath( "//*[@id='personaldtls']//div/following::input[@id='dob']" );

    /** The calendar. */
    By calendar = By.xpath( "//div[@class='dwcc']//div[@id='dob_dw_pnl_0']" );

    /** The month in calendar. */
    By monthInCalendar = By.xpath( "//*[@id='dob_dw_pnl_0']//div[@class='dw-cal-btnw']//div[@class='dw-cal-btnw-m']/span" );

    /** The next month btn. */
    By nextMonth_Btn = By.xpath( "//*[@id='dob_dw_pnl_0']//div[@class='dw-cal-btnw']//div[starts-with(@class,'dw-cal-next-m')]" );

    /** The day in calendar. */
    By dayInCalendar = By.xpath( "//div[starts-with(@id,'mobi')]//div[@class='dw-cal-table']//div[@class='dw-cal-row']/div" );

    /** The set btn in calendar. */
    By setBtnInCalendar = By.xpath( "//div[@class='dwbw dwb-s']//div[text()='Set']" );

    /** The tobacco user smoke. */
    By tobaccoUserSmoke = By.xpath( "//div[@id='Nri_No']//li[@class='dvCigaret']//div//input[@id='smoke']/following::label" );

    /** The pincode. */
    By pincode = By.xpath( "//div[@id='Nri_No']//li[@class='liPinClr']//div//input[@id='pincode']" );

    /** The city. */
    By city = By.xpath( "//div[@id='Nri_No']/ul/li[@class='liStateClr']//div//select[@id='city_id']/following::input" );

    /** The state. */
    By state = By.xpath( "//div[@id='Nri_No']//div//select[@id='state_id']" );

    /** The authorize chkbox. */
    By authorize_Chkbox = By.xpath( "//*[@id='personaldtls']//div/input[@id='disclaimer']/following::label[contains(text(),'I authorize HDFC Life')]" );

    /** The proceed btn. */
    By proceed_Btn = By.id( "btnPersonalDtls" );

}
