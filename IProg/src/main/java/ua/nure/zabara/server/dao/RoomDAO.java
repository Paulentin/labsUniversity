package ua.nure.zabara.server.dao;

import ua.nure.zabara.entity.Room;

import java.util.Collection;

public interface RoomDAO {
    /**
     * Add a room to order
     *
     * @return
     * @throws DAOException
     */
    public int addRoom(Room item) throws DAOException;

    /**
     * Add a room to order
     *
     * @return
     * @throws DAOException
     */
    public Room deleteRoom(int id) throws DAOException;

    Collection<Room> findByRenter(String pattern);

    /**
     * @return All rooms in order
     */
    public Collection<Room> listRooms();

    public Room findById(Integer id) throws DAOException;

}
