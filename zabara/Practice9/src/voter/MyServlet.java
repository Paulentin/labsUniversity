package voter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/vote")
public class MyServlet extends HttpServlet {

    static List<String> biathlonCount = new ArrayList();
    static List<String> footballCount = new ArrayList();
    static List<String> basketCount = new ArrayList();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(!session.isNew()){
            response.sendRedirect("error.jsp");
        }else {

            System.out.println("MyServlet#doGet");

            ServletContext sc = getServletContext();
            String listener = (String) sc.getAttribute("list");
            List<String> list = Arrays.asList(listener.split(" "));

            String name = request.getParameter("name");
            String vote = request.getParameter("activities");


            switch (vote){
                case "Biathlon":
                    biathlonCount.add(name);

                    break;
                case "Football":
                    footballCount.add(name);
                    break;
                case "Basketball":
                    basketCount.add(name);
                    break;
            }

            session.setAttribute("name", name);
            session.setAttribute("vote",vote);
            session.setAttribute("bia",biathlonCount);
            session.setAttribute("foot",footballCount);
            session.setAttribute("basket",basketCount);


            response.sendRedirect("inTask4.jsp");

        }
    }
}