package server.dao;

import hotel.entity.Room;

import java.util.Collection;


public interface RoomDAO {
	/**
	 * Add a book to order
	 * 
	 * @param item
	 * @return
	 * @throws DAOException 
	 */
	public int addRoom(Room item) throws DAOException;

	/**
	 * Add a book to order
	 * 
	 * @param id of room
	 * @return
	 * @throws DAOException 
	 */
	public Room deleteRoom(int id) throws DAOException;
	
	/**
	 * Find book with pattern author in the order
	 * 
	 * @param pattern
	 * @return
	 */
	public Collection<Room> findByStars(String pattern);

	/**
	 * 
	 * @return All rooms in order
	 */
	public Collection<Room> listRooms();

	public Room findById(Integer id) throws DAOException;

}
