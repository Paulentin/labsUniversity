package server.dao.inmemory;

import hotel.entity.Room;
import server.dao.DAOException;
import server.dao.RoomDAO;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InMemoryRoomDAO implements RoomDAO {
    private static HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
    private static int roomIndex;
    private static InMemoryRoomDAO dao;

    private InMemoryRoomDAO() {
        initRooms();
    }

    public static synchronized InMemoryRoomDAO getInstance() {
        if (dao == null)
            dao = new InMemoryRoomDAO();
        return dao;
    }


    @Override
    public int addRoom(Room item) throws DAOException {
        if (item == null)
            throw new DAOException("Oreder can not ba a null");
        item.setId(++roomIndex);
        rooms.put(roomIndex, item);
        return roomIndex;
    }

    @Override
    public Room deleteRoom(int id) throws DAOException {
        return rooms.remove(id);
    }

    @Override
    public Collection<Room> findByRenter(String pattern) {
        if (pattern == null || "".equals(pattern))
            return rooms.values();
        ArrayList<Room> found = new ArrayList<Room>();
        StringBuffer sb = new StringBuffer(".*");
        sb.append(pattern);
        sb.append(".*");
        Pattern p = Pattern.compile(sb.toString(), Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        for (Room o : rooms.values()) {
            List<Matcher> matcherList = new ArrayList<>();
            o.getWhorent().forEach(renter -> matcherList.add(p.matcher(renter.getTelNumber())));

            for (Matcher matcher : matcherList) {
                if (matcher.matches()) {
                    found.add(o);
                }
            }
        }
        return found;
    }

    @Override
    public Collection<Room> listRooms() {
        return rooms.values();
    }

    @Override
    public Room findById(Integer id) throws DAOException {
        Room b = rooms.get(id);
        if (b == null)
            throw new DAOException("Книга не найдена");
        return b;
    }

    private void initRooms() {
        Room[] rooms = new Room[]{
                new Room(1, 2, 3),
                new Room(2, 3, 2),
                new Room(3, 1, 2),
                new Room(4, 2, 2),
                new Room(5, 3, 1),
                new Room(6, 4, 3),
                new Room(7, 5, 1),
                new Room(8, 3, 2),
        };
        for (int i = 0; i < rooms.length; i++) {
            try {
                addRoom(rooms[i]);
            } catch (DAOException e) {
                throw new RuntimeException("Can not init");
            }
        }
    }
}
