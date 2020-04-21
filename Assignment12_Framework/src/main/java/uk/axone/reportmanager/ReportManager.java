package uk.axone.reportmanager;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.util.Date;

public class ReportManager {

    public static ExtentReports report;
    public static ExtentReports reports(){

        //check if an instance has already been created, if not create one

        if(report==null ) {

            //create a format of the report been created with date.html
            String reportFormat = new Date().toString().replace(" ", "_").replace(":", "_") + ".html";

            //create a variable to store the path of the report
            String reportPath = SystemUtils.getUserDir() + "/target/" + reportFormat;

            //create an instance of extent reports
            report = new ExtentReports(reportPath, true, DisplayOrder.OLDEST_FIRST);

            //load the config downloaded
            report.loadConfig(new File(SystemUtils.getUserDir() + "/src/main/resources/extent_config.xml"));

        }
        return report;

        }
}







