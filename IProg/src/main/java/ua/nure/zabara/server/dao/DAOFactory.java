package ua.nure.zabara.server.dao;

import ua.nure.zabara.server.dao.inmemory.InMemoryDAOFactory;

public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int DERBY = 1;
    public static final int INMEMORY = 2;
    public static final int MYSQL = 3;

    public static DAOFactory getDAOFactory(int whichFactory) {

        switch (whichFactory) {
            case INMEMORY:
                return new InMemoryDAOFactory();

            default:
                return null;
        }
    }

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract RoomDAO getRoomDAO();
}
