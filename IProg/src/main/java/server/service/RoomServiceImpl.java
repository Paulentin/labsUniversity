package server.service;

import hotel.entity.Room;
import server.dao.DAOException;
import server.dao.RoomDAO;
import server.dao.RoomDAOInMemoryImpl;

import java.util.Collection;

import javax.jws.WebService;


@WebService(serviceName="Rooms",
		portName="RoomPort",
		endpointInterface="main.java.server.service.RoomServiceImpl",
		targetNamespace="http://nure.ua/server/service")
public class RoomServiceImpl implements RoomService {
	private static RoomDAO roomDao = RoomDAOInMemoryImpl.instance();

	@Override
	public Room getRoom(int id) throws DAOException {
		return roomDao.findById(id);
	}

	@Override
	public Collection<Room> listRooms() {
		return roomDao.listRooms();
	}

	@Override
	public int addRoom(Room room) throws DAOException {
		return roomDao.addRoom(room);
	}

	@Override
	public Room deleteRoom(int id) throws DAOException {
		return roomDao.deleteRoom(id);
	}
	
}
