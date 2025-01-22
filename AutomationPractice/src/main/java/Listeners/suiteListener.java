package Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class suiteListener implements ISuiteListener {


    public void onStart(ISuite suite) {
        System.out.println("Suite started: " + suite.getName());
        // TODO Auto-generated method stub
    }


    public void onFinish(ISuite suite) {
        System.out.println("Suite finished: " + suite.getName());
    }

}
