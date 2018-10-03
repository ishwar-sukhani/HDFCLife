package com.hdfc.utility;

import org.openqa.selenium.By;

public interface CalculatePremiumLocators {

	// Locators of HomePage
	By buyOnline_Btn = By.xpath("//a[@class='tnt-sticky-btn']");
	
	// Locators of Insurance page
	By combiProtectionPlan_dropDown = By.xpath("//*[@id='s2id_autogen3']/following::select");
	By combiProtectionCalculate_Btn = By.xpath("//*[@id='s2id_autogen3']/following::a[@class='calculateAnchor opt-1-2']"); 
	
	// Locators of Insurance Form page
	By NRI_NO = By.xpath("//*[@id='personaldtls']//div[@class='selCircle']/input[@id='btnNo']/following::label");
	By maleImage = By.xpath("//*[@id='personaldtls']//div[@class='selCircle']/input[@id='malegender']/following::label");
	By femaleImage = By.xpath("//*[@id='personaldtls']//div[@class='selCircle']/input[@id='femalegender']/following::label");
	By firstName = By.xpath("//*[@id='Nri_No']//div[@class='customInput']/input[@id='fName']");
	By lastName = By.xpath("//*[@id='Nri_No']//div[@class='customInput']/input[@id='lName']");
	By mobileNumber = By.xpath("//input[@id='mobile']");
	By emailID = By.xpath("//*[@id='personaldtls']//div//input[@id='emailID']");
	By DOB = By.xpath("//*[@id='personaldtls']//div/following::input[@id='dob']");
	By tobaccoUserSmoke = By.xpath("//div[@id='Nri_No']//li[@class='dvCigaret']//div//input[@id='smoke']/following::label");
	By pincode = By.xpath("//div[@id='Nri_No']//li[@class='liPinClr']//div//input[@id='pincode']");
	By city = By.xpath("//div[@id='Nri_No']/ul/li[@class='liStateClr']//div//select[@id='city_id']/following::input");
	By state = By.xpath("//div[@id='Nri_No']//div//select[@id='state_id']");
	By authorize_Chkbox = By.xpath("//*[@id='personaldtls']//div/input[@id='disclaimer']/following::label[contains(text(),'I authorize HDFC Life')]");
	By proceed_Btn = By.id("btnPersonalDtls");
}
