package org.techrecipes.online.reports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import javax.jws.WebService;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by sjayapal on 10/9/2017.
 */
@WebService(serviceName = "reportsGenerationService")
public class ReportsGenerationService {
    public void reportsGenerationWithParams() {
        JasperPrint jasperPrint = null;
        try {
            JasperReport jasperReport = null;
            URL url = getClass().getClassLoader().getResource("org/techrecipes/online/reports/Leaf_Red.jasper");
            InputStream is = null;
            is = url.openStream();
            jasperReport = (JasperReport) JRLoader.loadObject(is);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("group_field", "50");
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "sathishj.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
