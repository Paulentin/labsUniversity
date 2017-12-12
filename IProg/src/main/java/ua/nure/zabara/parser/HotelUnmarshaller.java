package ua.nure.zabara.parser;

import ua.nure.zabara.entity.Hotel;

/**
 * Created by iryna.subota on 12.02.2017.
 */
public interface HotelUnmarshaller {

    Hotel unmarshal(String filePath);
}
