package voter;


import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    //private Map<HttpSession, String> sessions = new ConcurrentHashMap<HttpSession, String>();
    private static Set<HttpSession> sessionSet=new HashSet<>();

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String activities = sc.getInitParameter("list");
        System.out.println("list ==> " + activities);

        sc.setAttribute("list", activities);
    }

    public void contextDestroyed(ServletContextEvent sce) {/* no op */}

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        HttpSession session = request.getSession();
        if (session.isNew()) {
            sessionSet.add(session);

        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionSet.remove(httpSessionEvent.getSession());
    }
    public static Set<HttpSession> getSessionSet(){
        return sessionSet;
    }
}