package parser;

import hotel.entity.Hotel;

/**
 * Created by iryna.subota on 12.02.2017.
 */
public interface HotelUnmarshaller {

    Hotel unmarshal(String filePath);
}
