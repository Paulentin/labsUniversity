package ua.nure.zabara.service;

import ua.nure.zabara.hotel_itpoi.*;
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

@SuppressWarnings("serial")
public class RoomAddServlet extends HttpServlet {

    private RoomServiceClient service;
    private TheService client;

    @Override
    public void init() throws ServletException {
        try {
            service = new RoomServiceClient(
                    new URL("http://localhost:9000/RoomService?wsdl"));
            client = service.getProductServicePort();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/add.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ArrayList<Room> resultList = (ArrayList<Room>) client.getRoomsFromBusinessLayer();
        Room foundRoom = resultList.get(0);

        this.client.addRoom(new Room());
        resp.sendRedirect("");
    }

}
