package parser;

import hotel.entity.Hotel;

import java.io.IOException;

/**
 * Created by iryna.subota on 12.02.2017.
 */
public interface HotelMarshaller {

    void marshal(Hotel hotel, String filePath) throws IOException;
}