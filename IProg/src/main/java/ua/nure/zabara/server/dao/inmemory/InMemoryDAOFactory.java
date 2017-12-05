package server.dao.inmemory;

import server.dao.DAOFactory;
import server.dao.RoomDAO;

public class InMemoryDAOFactory extends DAOFactory {
    @Override
    public RoomDAO getRoomDAO() {
        return null;
    }
}
