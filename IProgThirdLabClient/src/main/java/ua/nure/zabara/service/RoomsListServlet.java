package ua.nure.zabara.service;

import ua.nure.zabara.hotel_itpoi.Room;
import ua.nure.zabara.lab.RoomServiceClient;
import ua.nure.zabara.lab.TheService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("serial")
public class RoomsListServlet extends HttpServlet {

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
        ArrayList<Room> resultList = (ArrayList<Room>) client.getRoomsFromBusinessLayer();

        req.setAttribute("rooms", resultList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/list.jsp");
        rd.forward(req, resp);
    }


}
