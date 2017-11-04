import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/text")
public class PrintText extends HttpServlet{

    private static final Logger LOG = Logger.getLogger(Calculate.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOG.info("doPost");
        String result=request.getParameter("text");
        System.out.println(result);
        request.setAttribute("text",result);
        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
        LOG.info("done doPOST");
    }
}