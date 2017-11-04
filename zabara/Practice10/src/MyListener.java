import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Set;

@WebListener
public class MyListener implements  HttpSessionListener {

    //private Map<HttpSession, String> sessions = new ConcurrentHashMap<HttpSession, String>();
    private static Set<String> sessionSet=new HashSet<>();


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sessionSet.add((String) httpSessionEvent.getSession().getAttribute("login"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionSet.remove(httpSessionEvent.getSession());
    }

   /* @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String activities = sc.getInitParameter("connection");
        System.out.println("got connection ==> " + activities);

        sc.setAttribute("connection", activities);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }*/
}