
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;


@WebServlet("/calc")
public class Calculate extends HttpServlet{

//    HttpSession httpSession =
    private static final Logger LOG = Logger.getLogger(Calculate.class);

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        LOG.info("doGet");
        process(request, response);
        LOG.info("done doGet");
    }


    private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        Double x= Double.valueOf(request.getParameter("x"));
        Double y= Double.valueOf(request.getParameter("y"));
        String operation= request.getParameter("op");

        System.out.println(operation);
            double res=0;
            switch (operation){
                case "minus":
                    res=x-y;
                    System.out.println(x-y);
                    break;
                case "plus":
                    res=x+y;
                    break;
                case "mul":
                    res=x*y;
                    break;
                case "div":
                    res=x/y;
                    break;
            }

        request.setAttribute("result",res);




        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);



    }
}
