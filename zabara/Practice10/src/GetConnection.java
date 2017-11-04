import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;



public class GetConnection {


    public static Connection getCon() throws SQLException {
    DataSource ds = null;
        Context initContext = null;
        try {
            initContext = new InitialContext();

        Context envContext = (Context) initContext
                .lookup("java:/comp/env");

        ds = (DataSource) envContext
                .lookup("jdbc/mydb_MYSQL");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return ds.getConnection();
    }

}
