
package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReporter {

    private static ExtentReports extentReport;
    private static ExtentTest test;
    private static ExtentTest node;

    public static ExtentReports getExtentReport() {

        if (extentReport == null) {

            String reportDir = System.getProperty("user.dir") + "/reports";
            new File(reportDir).mkdirs();

            String reportPath = reportDir + "/extentreport.html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportPath);

            reporter.config().setReportName("Selenium Java Hybrid Framework");
            reporter.config().setDocumentTitle("Test Results");

            extentReport = new ExtentReports();
            extentReport.attachReporter(reporter);

            extentReport.setSystemInfo("Operating System",
                    System.getProperty("os.name"));

            extentReport.setSystemInfo("OS Version",
                    System.getProperty("os.version"));

            extentReport.setSystemInfo("User Name",
                    System.getProperty("user.name"));
        }

        return extentReport;
    }

    public static void createTest(String testName) {
        test = getExtentReport().createTest(testName);
        node = null;
    }

    public static void createNode(String nodeName) {

        if (test == null) {
            throw new IllegalStateException(
                    "Create a test before creating a node"
            );
        }

        node = test.createNode(nodeName);
    }

    public static void logPass(String message) {
        if (node == null) {
            throw new IllegalStateException("Extent node is not initialized");
        }
        node.pass(message);
    }

    public static void logInfo(String message) {
        if (node == null) {
            throw new IllegalStateException("Extent node is not initialized");
        }
        node.info(message);
    }

    public static void logFail(String message) {
        if (node == null) {
            throw new IllegalStateException("Extent node is not initialized");
        }

        node.fail(message);
    }

    public static void flushReport() {
        getExtentReport().flush();
    }

    public static void logScenarioFail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }
}
