package ua.nure.zabara.parser;

import ua.nure.zabara.entity.Hotel;
import ua.nure.zabara.entity.Renter;
import ua.nure.zabara.entity.Room;

import java.sql.Date;


public class Util {

    public static Hotel createHotel() {
        Hotel hotel = new Hotel();

        Room room = new Room();

        hotel.addRoom(room);

        room.setId(3);
        room.setStars(5);
        Renter r = new Renter();
        r.setName("Pavlo Zabara");
        r.setTelNumber("+380660219830");
        r.setDateStart(new Date(20022002));
        r.setDateEnd(new Date(20021996));

        room.addRenter(r);
        room.setStaffAmount(2);
        return hotel;
    }
}
