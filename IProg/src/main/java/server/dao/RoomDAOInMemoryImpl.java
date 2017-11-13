package server.dao;

import dbtable.DBTable;
import dbtable.DBTableFabrique;
import dbtable.Filter;
import hotel.entity.Renter;
import hotel.entity.Room;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;


public class RoomDAOInMemoryImpl implements RoomDAO {

	DBTable<Room> rooms = DBTableFabrique.instance();

	private static RoomDAOInMemoryImpl instance;

	private RoomDAOInMemoryImpl() {
		initRooms();
	}

	public static synchronized RoomDAOInMemoryImpl instance() {
		if (instance == null) {
			instance = new RoomDAOInMemoryImpl();
		}
		return instance;
	}

	@Override
	public synchronized int addRoom(Room item) {
		int id = rooms.insert(item);
		item.setId(id);
		try {
			rooms.update(id, item);
		} catch (SQLException e) {
			// do nothing, always exist
		}
		return id;
	}

	@Override
	public synchronized Room deleteRoom(int id) throws DAOException {
		try {
			return rooms.delete(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

    /**
     * Find book with pattern author in the order
     *
     * @param pattern
     * @return
     */
    @Override
    public Collection<Room> findByStars(String pattern) {
        return null;
    }

    Filter titleFilter = (pattern, item) -> {
        String p = (String) pattern;
        Room it = (Room) item;
        return it.getPrice().toString().contains(p.toUpperCase());
    };

	Filter renterFilter = (pattern, item) -> {
        String p = (String) pattern;
        Room it = (Room) item;
        Set<Renter> renterSet = it.getWhorent();
        for (Iterator<Renter> iterator = renterSet.iterator(); iterator.hasNext();) {
            Renter renter = iterator.next();
            if (renter.getName().toUpperCase().contains(p.toUpperCase()))
                return true;
        }
        return false;
    };

	@Override
	public Collection<Room> listRooms() {
		return rooms.selectAll();
	}

	@Override
	public Room findById(Integer id) throws DAOException {
		try {
			return rooms.get(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	private Room newRoom(int id, Renter renter, int stars, boolean barFridge, int staffAmount, BigDecimal price) {
		Room room = new Room();
		room.setId(id);
		room.addRenter(renter);
		room.setStars(stars);
		room.setBarFridge(barFridge);
		room.setStaffAmount(staffAmount);
		room.setPrice(price);
		return room;
	}

	private void initRooms() {
		Room[] books = new Room[] {
				newRoom(1,
						new Renter("Vlad","+380997099600",new Date(888888),new Date(89988889)),
						3, true,2,new BigDecimal( 3)),
				newRoom(2,
						new Renter("Semen","+380997099680",new Date(888888),new Date(89988889)),
						4, false, 2,new BigDecimal(222)),
                newRoom(3,
						new Renter("Igor","+380997099602",new Date(888888),new Date(89988889)),
						4, false, 2,new BigDecimal(222)),
                newRoom(4,
						new Renter("Sass","+380997099603",new Date(888888),new Date(89988889)),
						4, false, 2,new BigDecimal(222)),
                newRoom(5,
						new Renter("Qwe","+380997099604",new Date(888888),new Date(89988889)),
						4, false, 2,new BigDecimal(222)),
                newRoom(6,
						new Renter("Rewd","+380997099623",new Date(888888),new Date(89988889)),
						4, false, 2,new BigDecimal(222)),

				};
		for (int i = 0; i < books.length; i++) {
			addRoom(books[i]);
		}
	}
}
