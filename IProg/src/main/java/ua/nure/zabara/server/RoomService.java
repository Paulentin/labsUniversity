package ua.nure.zabara.server;

import ua.nure.zabara.entity.Room;
import ua.nure.zabara.server.dao.DAOException;
import ua.nure.zabara.server.dao.RoomDAO;
import ua.nure.zabara.server.dao.inmemory.InMemoryRoomDAO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;
import java.util.HashSet;

@WebService
public class RoomService {

    private static RoomDAO roomDao = InMemoryRoomDAO.getInstance();

    @WebMethod
    public Room getRoom(int id) throws DAOException {
        return roomDao.findById(id);
    }

    @WebMethod
    public Collection<Room> getRoomsFromBusinessLayer() {
        System.out.println("gettingRooms");
        Collection<Room> rooms = new HashSet<Room>();
        rooms.addAll(roomDao.listRooms());
        for (Room room : rooms) {
            System.out.println(room);
        }
        return rooms;
    }

    @WebMethod
    public Room addRoom(Room room) throws DAOException {
        room.setId(roomDao.addRoom(room));

        return room;
    }

    @WebMethod
    public Room deleteRoom(int id) throws DAOException {
        return roomDao.deleteRoom(id);
    }

    //	@POST
    @WebMethod
    public Room updateRoom(Room room) throws DAOException {
        roomDao.deleteRoom(room.getId());
        room.setId(roomDao.addRoom(room));
        return room;
    }
}
