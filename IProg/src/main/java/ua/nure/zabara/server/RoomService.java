package server;

import hotel.entity.Room;
import server.dao.DAOException;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "RoomService", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
public interface RoomService {

	@WebMethod(operationName = "getRoom", action = "urn:GetRoom")
	@RequestWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.GetRoom", localName = "getRoom", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@ResponseWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.GetRoomResponse", localName = "getRoomResponse", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@WebResult(name = "return")
	public abstract Room getRoom(
            @WebParam(name = "id") int id)
			throws DAOException;

	@WebMethod(operationName = "addRoom", action = "urn:AddRoom")
	@RequestWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.AddRoom", localName = "addRoom", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@ResponseWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.AddRoomResponse", localName = "addRoomResponse", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@WebResult(name = "return")
	public abstract Room addRoom(
            @WebParam(name = "book") Room book)
			throws DAOException;

	@WebMethod(operationName = "updateRoom", action = "urn:UpdateRoom")
	@RequestWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.UpdateRoom", localName = "updateRoom", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@ResponseWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.UpdateRoomResponse", localName = "updateRoomResponse", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@WebResult(name = "return")
	public abstract Room updateRoom(
            @WebParam(name = "book") Room book)
					throws DAOException;
	
	@WebMethod(operationName = "deleteRoom", action = "urn:DeleteRoom")
	@RequestWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.DeleteRoom", localName = "deleteRoom", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@ResponseWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.DeleteRoomResponse", localName = "deleteRoomResponse", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@WebResult(name = "return")
	public abstract Room deleteRoom(
            @WebParam(name = "id") int id)
					throws DAOException;
	
	@WebMethod(operationName = "listRooms", action = "urn:ListRooms")
	@RequestWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.ListRooms", localName = "listRooms", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@ResponseWrapper(className = "ua.nure.order.ua.nure.zabara.server.service.jaxws.ListRoomsResponse", localName = "listRoomsResponse", targetNamespace = "http://service.ua.nure.zabara.server.order.nure.ua/")
	@WebResult(name = "return")
	public abstract Collection<Room> listRooms(
            @WebParam(name = "pattern") String pattern);

}