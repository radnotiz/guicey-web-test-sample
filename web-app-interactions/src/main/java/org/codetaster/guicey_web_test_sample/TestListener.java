package org.codetaster.guicey_web_test_sample;

import com.beust.jcommander.internal.Lists;
import org.testng.IConfigurationListener2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Collections;
import java.util.List;

public class TestListener implements ITestListener, IConfigurationListener2 {

    //private TestScope testScope = new TestScope();

    public static List<String> list = Collections.synchronizedList(Lists.<String>newArrayList());

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (String string : list)
                    System.err.println(string);
            }
        });
    }

    @Override
    public void onTestStart(ITestResult result) {
        list.add("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        list.add("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onStart(ITestContext context) {
        list.add("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        list.add("onFinish");
    }

    @Override
    public void beforeConfiguration(ITestResult tr) {
        list.add("beforeConfiguration");
    }

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        list.add("onConfigurationSuccess " + itr.getMethod().isAfterTestConfiguration());
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
