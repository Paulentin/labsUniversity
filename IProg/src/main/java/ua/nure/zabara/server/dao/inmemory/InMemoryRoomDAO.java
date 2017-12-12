package ua.nure.zabara.server.dao.inmemory;

import ua.nure.zabara.entity.Hotel;
import ua.nure.zabara.entity.Room;
import ua.nure.zabara.parser.HotelMarshaller;
import ua.nure.zabara.parser.HotelUnmarshaller;
import ua.nure.zabara.parser.dom.DomMarshaller;
import ua.nure.zabara.parser.dom.DomUnmarshaller;
import ua.nure.zabara.server.dao.DAOException;
import ua.nure.zabara.server.dao.RoomDAO;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InMemoryRoomDAO implements RoomDAO {
    private static HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
    private static int roomIndex;
    private static InMemoryRoomDAO dao;
    private static HotelMarshaller marshaller;

    private InMemoryRoomDAO() {
        marshaller = new DomMarshaller();
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
        try {
            marshaller.marshal(createHotel(),"src/main/resources/xml/hotel.xml" );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomIndex;
    }

    private Hotel createHotel() {
        HashSet<Room> roomSet = new HashSet<>();
        for (Room room : rooms.values()) {
            roomSet.add(room);
        }
        return new Hotel(roomSet);
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
            o.getRented().forEach(renter -> matcherList.add(p.matcher(renter.getTelNumber())));

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
        System.out.println("Storage initialized");
        HotelUnmarshaller unmarshaller = new DomUnmarshaller();
        Hotel hotel = unmarshaller.unmarshal("src/main/resources/xml/dom.xml");

        int i =0;
        for (Room room : hotel.getRooms()) {
            rooms.put(i++,room);
        }
    }
}
