import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/part3")
public class Part3 extends HttpServlet{

    private static List<String> sessionSet= new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session=req.getSession();

        String login = req.getParameter("name");
        System.out.println(login);
        sessionSet.add(login);
        session.setAttribute("sessions",sessionSet);

        resp.sendRedirect("index.jsp");
    }
}
