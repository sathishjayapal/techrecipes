package org.techrecipes.online.references;
import org.h2.tools.Server;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by sathishjayapal on 7/18/16.
 */
public class DataFiller {
    public void setUpDB() {
        Server server = null;
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:mem;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM  'classpath:scripts/createdata.sql'\\;RUNSCRIPT FROM 'classpath:scripts/populate.sql'";
            conn = DriverManager.getConnection(url, "sa", "");
            server = Server
                    .createTcpServer().start();
            System.out.println("Server started and connection is open.");
            System.out.println("URL: jdbc:h2:" + server.getURL() + "/mem:test");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select EmployeeName from Employees");
            while (rset.next()) {
                String name = rset.getString(1);
                System.out.println(name);
            }
            // now start the H2 Console here or in another process using
            // java org.h2.tools.Console -web -browser
            System.out.println("Press [Enter] to stop.");
            System.in.read();
            System.out.println("Stopping server and closing the connection");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.stop();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

