package com.hdfc.tests;

import com.hdfc.helper.BuyPlan;
import com.hdfc.utility.DriverUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AppMain.
 */
public class AppMain {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args ) {

        BuyPlan buyPlan = new BuyPlan();
        buyPlan.openHDFCLife();
//        buyPlan.buyInsuranceOnline();
//        buyPlan.buyHDFCLifeProtectionPlans();
        buyPlan.enterPersonalDetails( DriverUtil.getDriver() );
        buyPlan.closeHDFCLife();
    }

}
