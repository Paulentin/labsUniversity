package ua.nure.zabara.server.dao.inmemory;

import ua.nure.zabara.server.dao.DAOFactory;
import ua.nure.zabara.server.dao.RoomDAO;

public class InMemoryDAOFactory extends DAOFactory {
    @Override
    public RoomDAO getRoomDAO() {
        return null;
    }
}
