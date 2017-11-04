package ua.nure.zabara.SummaryTask3.settings;

import ua.nure.zabara.SummaryTask3.classes.Weapons;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import ua.nure.zabara.SummaryTask3.parsers.DOMController;
import ua.nure.zabara.SummaryTask3.parsers.SAXController;
import ua.nure.zabara.SummaryTask3.parsers.StAXController;
import static ua.nure.zabara.SummaryTask3.settings.Settings.*;

/**
 *
 * @author paulentin
 */
public class XMLParser {

    public static final int DOMParser = 1;
    public static final int StAXParser = 3;
    public static final int SAXParser = 2;

    public static boolean validate() {
        Source xmlFile = null;
        File schemaFile;
        SchemaFactory schemaFactory;
        Schema schema;
        try {
            schemaFile = new File(xsdFileName);
            xmlFile = new StreamSource(new File(xmlFileName));
            schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException | IOException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    public static IFileParser geParser(int parser) {
        switch (parser) {
            case DOMParser:
                return new DOMController();
            case SAXParser:
                return new SAXController();
            case StAXParser:
                return new StAXController();
            default:
                return null;
        }
    }

    public static void transform() {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(xslFileName));
            transformer.transform(new javax.xml.transform.stream.StreamSource(xmlFileName),
                    new javax.xml.transform.stream.StreamResult(new FileOutputStream(htmlFileName)));
        } catch (TransformerFactoryConfigurationError | FileNotFoundException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getMenu() {
        BufferedReader br;
        String c;
        boolean b = true;
        IFileParser parser = null;
        Weapons weapons;
        try {
            br = new BufferedReader(new InputStreamReader(System.in, "utf8"));
            while (b) {
                System.out.println("1. Validate xml\n2. Use DOM parser\n3. Use SAX parser\n4. Use StAX parse\n5. Parse xml\n6. Transform to html\nn to exit");
                c = br.readLine();
                switch (c) {
                    case "1":
                        System.out.println("validation...");
                        validate();
                        break;
                    case "2":
                        System.out.println("DOM parser");
                        parser = geParser(DOMParser);
                        break;
                    case "3":
                        System.out.println("SAX parser");
                        parser = geParser(SAXParser);
                        break;
                    case "4":
                        System.out.println("StAX parser");
                        parser = geParser(StAXParser);
                        break;
                    case "5":
                        System.out.println("parsing...");
                        if (parser == null) {
                            System.out.println("You have to chose parser before");
                        } else {
                            weapons = parser.getWeapons();
                            System.out.println(weapons);
                        }
                        break;
                    case "6":
                        System.out.println("transformation to html...");
                        transform();
                        break;
                    case "n":
                        System.out.println("The End");
                        b = false;
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        getMenu();
    }
}
