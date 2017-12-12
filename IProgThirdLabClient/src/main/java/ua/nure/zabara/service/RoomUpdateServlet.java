package ua.nure.zabara.service;

import ua.nure.zabara.hotel_itpoi.Renter;
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
import java.sql.Date;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class RoomUpdateServlet extends HttpServlet {

    private RoomServiceClient service;
    private TheService client;

    @Override
    public void init() throws ServletException {
        try {
            service = new RoomServiceClient(new URL("http://localhost:9000/hotel/Service?wsdl"));
            client = service.getProductServicePort();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Room> resultList = (ArrayList<Room>) client.getRoomsFromBusinessLayer();
        int id = Integer.parseInt(req.getParameter("id"));
        Room foundRoom = null;
        for (Room room : resultList) {
            if (room.getId() == id) {
                foundRoom = room;
            }
        }
        if (foundRoom == null) {
            resp.getWriter().println("Room with such an id was not found.");
        } else {
            req.setAttribute("room", foundRoom);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit_room.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ArrayList<Room> resultList = (ArrayList<Room>) client.getRoomsFromBusinessLayer();
        int id = Integer.parseInt(req.getParameter("room.id"));
        Room foundroom = null;
        for (Room room : resultList) {
            if (room.getId() == id) {
                foundroom = room;
            }
        }
        Room room = new Room(Integer.parseInt(req.getParameter("room.id")),
                req.getParameter("room.price"),
                Integer.parseInt(req.getParameter("room.stars")),
                Integer.parseInt(req.getParameter("room.staffamount")),
                null,
                req.getParameter("room.habBarFridge"));

        Renter renter = new Renter(
                req.getParameter("renter.name"),
                req.getParameter("renter.telNumber"),
                Date.valueOf(req.getParameter("renter.dateStart")),
                Date.valueOf(req.getParameter("renter.dateEnd")));

        resp.sendRedirect("orders");
    }

}
