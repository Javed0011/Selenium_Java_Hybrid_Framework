package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;


public class ExtentReporter {
	static ExtentReports extentReport;
    public static ExtentReports getExtentReport() {
        String reportDir = System.getProperty("user.dir") + "\\reports";
        new File(reportDir).mkdirs();

        String extentReportPath = reportDir + "\\extentreport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
        reporter.config().setReportName("Selenium Java Hybrid Framework");
        reporter.config().setDocumentTitle("Test Results");

        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);

        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReport.setSystemInfo("OS Version", System.getProperty("os.version"));
        extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
        return extentReport;
    }
}