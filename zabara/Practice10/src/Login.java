import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final String SQL_GET_USER_BY_NAME = "SELECT * FROM users WHERE id=?";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;

        String login = req.getParameter("login");
        String pass= req.getParameter("pass");

        user.setLogin(login);
        user.setPassword(pass);
        HttpSession session = req.getSession();
        session.setAttribute("user",user);

        PreparedStatement pstmnt;
        ResultSet rs = null;
        Connection con=null;
        try {
             con =GetConnection.getCon();

             pstmnt = con.prepareStatement(SQL_GET_USER_BY_NAME);
             pstmnt.setString(1, login);

             rs = pstmnt.executeQuery();

             if (rs.next()) {

             }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
