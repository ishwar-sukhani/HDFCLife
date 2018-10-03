package com.hdfc.tests;

import com.hdfc.helper.BuyPlan;

public class AppMain {

	public static void main(String[] args) {

		BuyPlan buyPlan = new BuyPlan();
		buyPlan.openHDFCLife();
		buyPlan.buyInsuranceOnline();
		buyPlan.buyHDFCLifeProtectionPlans();
//		buyPlan.closeHDFCLife();
	}

}
