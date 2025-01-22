package Listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultsListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test succeeded: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started: " + context.getName());
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished: " + context.getName());
    }

}