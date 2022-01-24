package org.techrecipes.online.reports;
//import javax.xml.ws.WebServiceClient;
/**
 * Created by sjayapal on 10/9/2017.
 */
//@WebServiceClient
public class ReportsMain {
    public static void CallReportService() {
        ReportsGenerationService reportsGenerationService = new ReportsGenerationService();
        reportsGenerationService.reportsGenerationWithParams();
    }
}
