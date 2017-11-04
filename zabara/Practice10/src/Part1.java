import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jstl")
public class Part1 extends HttpServlet{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        int [] ar = {1,2,3,4,5,6,7,8,9};

        request.setAttribute("array",ar);
        request.getRequestDispatcher("part2.jsp").forward(request, response);


    }


}
