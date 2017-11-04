package parser;

import hotel.entity.Hotel;
import hotel.entity.Renter;
import hotel.entity.Room;

import java.sql.Date;

/**
 * Created by iryna.subota on 12.02.2017.
 */

public class Util {

    public static Hotel createBookShop() {
        Hotel hotel = new Hotel();

        Room room = new Room();

        hotel.addRoom(room);

        room.setId(3);
        room.setStars(5);
        room.addRenter(new Renter(
                "Pavlo Zabara",
                "+380660219830",
                new Date(20022002),
                new Date(20021996)));
        room.setStaffAmount(2);
        return hotel;
    }
}
