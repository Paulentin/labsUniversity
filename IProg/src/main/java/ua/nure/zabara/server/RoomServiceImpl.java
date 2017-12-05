package ua.nure.zabara.server;

import hotel.entity.Room;
import server.dao.DAOException;
import server.dao.RoomDAO;
import server.dao.inmemory.InMemoryRoomDAO;

import javax.jws.WebService;
import javax.ws.rs.PathParam;
import java.util.Collection;
import java.util.HashSet;

@WebService(targetNamespace = "http://server.zabara.nure.ua/",
        endpointInterface = "ua.nure.zabara.server.RoomService",
        portName = "RoomServicePort",
        serviceName = "RoomService")
public class RoomServiceImpl implements server.RoomService {

    public RoomServiceImpl() {
    }

    private static RoomDAO roomDao = InMemoryRoomDAO.getInstance();

    /*
        @GET
        @Path(value="/{id}")
        @Produces(MediaType.APPLICATION_XML)
        @Override*/
    public Room getRoom(@PathParam(value = "id") int id) throws DAOException {
        return roomDao.findById(id);
    }

    /*
        @Path(value="/list/{pattern}")
        @GET
        @Produces(MediaType.APPLICATION_XML)*/
    @Override
    public Collection<Room> listRooms(/*@PathParam(value="pattern")*/ String pattern) {
        HashSet<Room> rooms = new HashSet<Room>();
        rooms.addAll(roomDao.findByRenter("+380660219830"));
        return rooms;
    }

    /*
        @GET
        @Produces(MediaType.APPLICATION_XML)*/
    public Room[] listAll() {
        return roomDao.listRooms().toArray(new Room[0]);
    }

    /*@Path(value="/add")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)*/
    @Override
    public Room addRoom(Room room) throws DAOException {
        room.setId(roomDao.addRoom(room));
        return room;
    }

    /*
        @Path(value="/delete/{id}")
        @DELETE
        @Produces(MediaType.APPLICATION_XML)*/
    @Override
    public Room deleteRoom(@PathParam(value = "id") int id) throws DAOException {
        return roomDao.deleteRoom(id);
    }

    //	@POST
    @Override
    public Room updateRoom(Room room) throws DAOException {
        roomDao.deleteRoom(room.getId());
        room.setId(roomDao.addRoom(room));
        return room;
    }
}
