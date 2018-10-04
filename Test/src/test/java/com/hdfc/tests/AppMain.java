package com.hdfc.tests;

import java.awt.AWTException;

import com.hdfc.bl.BuyPlan;

/**
 * The Class AppMain.
 */
public class AppMain {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws InterruptedException
     * @throws AWTException
     */
    public static void main( String[] args ) throws InterruptedException, AWTException {

        BuyPlan buyPlan = new BuyPlan();
        buyPlan.openHDFCLife();
        buyPlan.buyInsuranceOnline();
        buyPlan.buyHDFCLifeProtectionPlans();
        buyPlan.closeHDFCLife();
    }

}
