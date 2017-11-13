package server.service;

import hotel.entity.Room;
import server.dao.DAOException;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;



@WebService(targetNamespace="http://nure.ua/server/service")
public interface RoomService {

	@WebMethod()
	@WebResult(targetNamespace="http://nure.ua/entity")
	Room getRoom(
			@WebParam(name = "id")
					int id) throws DAOException;

	@WebMethod()
	int addRoom(
			@WebParam(name = "room", targetNamespace = "http://nure.ua/entity")
					Room book) throws DAOException;
	
	@WebMethod()
	@WebResult(targetNamespace="http://nure.ua/entity")
	Room deleteRoom(
			@WebParam(name = "id")
					int id) throws DAOException;
	
	@WebMethod()
	@WebResult(targetNamespace="http://nure.ua/entity")
	Collection<Room> listRooms();



}