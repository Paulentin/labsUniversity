package ua.nure.zabara.client;

import ua.nure.zabara.hotel_itpoi.Renter;
import ua.nure.zabara.hotel_itpoi.Room;
import ua.nure.zabara.lab.RoomServiceClient;
import ua.nure.zabara.lab.TheService;

import java.net.URL;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            RoomServiceClient service = new RoomServiceClient(new URL("http://localhost:9000/RoomServiceClient?wsdl"));
            TheService client = service.getProductServicePort();
            Collection<Room> rooms = client.getRoomsFromBusinessLayer();
            if (rooms == null) {
                System.err.println("rooms null");
            }
            System.out.println("\nPrint all rooms.");
            for (Room room : rooms) {
                printRoom(room);
            }

            Set<Renter> renterSet = new HashSet<>();
            renterSet.add(new Renter("Vasya", "+380660219830", new Date(56565), new Date(5656989)));
            client.addRoom(new Room(99, "5665", 5, 5,
                    renterSet, "true"));



            rooms = client.getRoomsFromBusinessLayer();
            System.out.println("\n___________________________\nPrint all rooms.");
            for (Room room : rooms) {
                printRoom(room);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printRoom(Room room) {
        System.out.println("nice room though");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room id: ").append(room.getId());
        stringBuilder.append("\nRenter telephone number: ");
        if (room.getRented() != null) {
            room.getRented().forEach((renter) -> stringBuilder
                    .append(renter.getName())
                    .append(" ")
                    .append(renter.getTelNumber()).append("\n"));
        }
        stringBuilder.append("\nStars: ").append(room.getStars());
        stringBuilder.append("\nBarfridge: ").append(room.isBarfridge());

        System.out.println(stringBuilder.toString());
    }

}
