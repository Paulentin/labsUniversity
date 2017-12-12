package ua.nure.zabara.service;

import ua.nure.zabara.lab.RoomServiceClient;
import ua.nure.zabara.lab.TheService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("serial")
public class RoomRemoveServlet extends HttpServlet {

    private RoomServiceClient service;
    private TheService client;

    @Override
    public void init() throws ServletException {
        try {
            service = new RoomServiceClient(new URL("http://localhost:9000/RoomService?wsdl"));
            client = service.getProductServicePort();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        client.deleteRoom(id);
        resp.sendRedirect("orders");
    }
}
