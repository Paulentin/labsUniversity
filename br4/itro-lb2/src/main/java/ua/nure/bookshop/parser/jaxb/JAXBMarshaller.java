package ua.nure.bookshop.parser.jaxb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import ua.nure.bookshop.entity.BookShop;
import ua.nure.bookshop.parser.BookMarshaller;
import ua.nure.bookshop.parser.Util;

public class JAXBMarshaller implements BookMarshaller {

    public void marshal(BookShop bookShop, String filePath) throws IOException {
        OutputStream os = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(BookShop.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                    "http://nure.ua/bookShop ../xsd/books.xsd");
            os = new FileOutputStream(filePath);
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(bookShop, os);
            m.marshal(bookShop, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }

    public static void main(String[] arg) throws Exception {
        BookMarshaller jaxbMarshaller = new JAXBMarshaller();
        jaxbMarshaller.marshal(Util.createBookShop(), "src/main/resources/xml/jaxb.xml");
    }
}
