package ua.nure.zabara.SummaryTask3.parsers;

import ua.nure.zabara.SummaryTask3.classes.KnifeType;
import ua.nure.zabara.SummaryTask3.classes.VisualType;
import ua.nure.zabara.SummaryTask3.classes.Weapons;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ua.nure.zabara.SummaryTask3.settings.IFileParser;
import ua.nure.zabara.SummaryTask3.settings.Settings;

import static ua.nure.zabara.SummaryTask3.settings.Settings.*;

/**
 *
 * @author paulentin
 */
public class DOMController implements IFileParser {

    public DOMController() {
    }

    @Override
    public Weapons getWeapons() {
        Weapons result = new Weapons();
        List<KnifeType> knifes = new ArrayList<>();
        VisualType visualType;

        try {

            File fXmlFile = new File(xmlFileName);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(KNIFE);
            KnifeType knife;
            Element eElement;

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    knife = new KnifeType();
                    eElement = (Element) nNode;

                    knife.setId(eElement.getAttribute(ID));
                    knife.setType(getTagValue(TYPE, eElement));

                    visualType = new VisualType();
                    visualType.setBloodsink(Boolean.parseBoolean(getTagValue(BLOODSINK, eElement)));
                    visualType.setHandle(getTagValue(HANDLE, eElement));
                    visualType.setLength(Double.parseDouble(getTagValue(LENGTH, eElement)));
                    visualType.setWidth(Double.parseDouble(getTagValue(WIDTH, eElement)));

                    knife.setVisual(visualType);
                    knife.setValue(Boolean.parseBoolean(getTagValue(VALUE, eElement)));

                    knifes.add(knife);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | NumberFormatException e) {
            System.err.println(e);
        }
        result.setKnife(knifes);
        return result;
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = nlList.item(0);
        return nValue.getNodeValue();
    }



    // //////////////////////////////////////////////////////
    // Static util methods
    // //////////////////////////////////////////////////////

    /**
     * Creates and returns DOM of the Weapons container.
     *
     * @param weapons
     *            Test object.
     * @throws ParserConfigurationException
     */
    public static Document getDocument(Weapons weapons) throws ParserConfigurationException {

        // obtain DOM parser
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // set properties for Factory

        // XML document contains namespaces
        dbf.setNamespaceAware(true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        // create root element
        Element wElement = document.createElement(Settings.WEAPONS);

        // add root element
        document.appendChild(wElement);

        // add knives
        for (KnifeType knife : weapons.getKnife()) {




            // add knife
            Element kElement = document.createElement(Settings.KNIFE);
            kElement.setAttribute(Settings.ID,knife.getId());
            wElement.appendChild(kElement);


            // add type
            Element typeElement = document.createElement(Settings.TYPE);
            typeElement.setTextContent(knife.getType());
            kElement.appendChild(typeElement);

            // add handy
            Element handyElement = document.createElement(Settings.HANDY);
            typeElement.setTextContent(knife.getHandy());
            kElement.appendChild(handyElement);

            //add visual
            Element visualElement = document.createElement(Settings.VISUAL);
            kElement.appendChild(visualElement);
            VisualType vs=knife.getVisual();

            // add length
            Element lenElement = document.createElement(Settings.LENGTH);
            typeElement.setTextContent(Double.toString(vs.getLength()));
            visualElement.appendChild(lenElement);

             // add width
            Element lebElement = document.createElement(Settings.WIDTH);
            typeElement.setTextContent(Double.toString(vs.getWidth()));
            visualElement.appendChild(lebElement);

            // add handle
            Element handleElement = document.createElement(Settings.HANDLE);
            typeElement.setTextContent(vs.getHandle());
            visualElement.appendChild(handleElement);


            // add bloodsinking
            Element bloodElement = document.createElement(Settings.BLOODSINK);
            typeElement.setTextContent(Boolean.toString(vs.isBloodsink()));
            visualElement.appendChild(bloodElement);



        }

        return document;
    }



    /**
     * Saves Test object to XML file.
     *
     * @param weapons
     *            Test object to be saved.
     * @param xmlFileName
     *            Output XML file name.
     */
    public static void saveToXML(Weapons weapons, String xmlFileName)
            throws ParserConfigurationException, TransformerException {
        // Test -> DOM -> XML
        saveToXML(getDocument(weapons), xmlFileName);
    }

    /**
     * Save DOM to XML.
     *
     * @param document
     *            DOM to be saved.
     * @param xmlFileName
     *            Output XML file name.
     */
    public static void saveToXML(Document document, String xmlFileName)
            throws TransformerException {

        StreamResult result = new StreamResult(new File(xmlFileName));

        // set up transformation
        TransformerFactory tf = TransformerFactory.newInstance();
        javax.xml.transform.Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        // run transformation
        t.transform(new DOMSource(document), result);
    }

}
