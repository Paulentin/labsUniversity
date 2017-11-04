package ua.nure.zabara.SummaryTask3.controller;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.zabara.SummaryTask3.constants.Constants;
import ua.nure.zabara.SummaryTask3.constants.XML;
import ua.nure.zabara.SummaryTask3.entity.Ammunitia;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.zabara.SummaryTask3.entity.Visuality;
import ua.nure.zabara.SummaryTask3.entity.Weapon;

public class DOMController {

    private String xmlFileName;

    private Ammunitia ammo;

    public DOMController(String xmlFileName){
        this.xmlFileName=xmlFileName;
    }

    public Ammunitia getAmmo() {
        return ammo;
    }


    /**
     * Parses XML document.
     *
     * @param validate
     *            If true validate XML document against its XML schema.
     */
    public void parse(boolean validate)
            throws ParserConfigurationException, SAXException, IOException {

        // obtain DOM parser
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // set properties for Factory

        // XML document contains namespaces
        dbf.setNamespaceAware(true);

        // make parser validating
        if (validate) {
            // turn validation on
            dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);

            // turn on xsd validation
            dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        DocumentBuilder db = dbf.newDocumentBuilder();

        // set error handler
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                // throw exception if XML document is NOT valid
                throw e;
            }
        });

        // parse XML document
        Document document = db.parse(xmlFileName);

        // get root element
        Element root = document.getDocumentElement();

        // create container
        ammo = new Ammunitia();

        // obtain questions nodes
        NodeList weaponNodes = root
                .getElementsByTagName(XML.WEAPON.value());

        // process questions nodes
        for (int j = 0; j < weaponNodes.getLength(); j++) {
            Weapon question = getWeapon(weaponNodes.item(j));
            // add question to container
            ammo.getWeapons().add(question);
        }
    }
    /**
     * Extracts question object from the question XML node.
     *
     * @param weaponNode
     *            Weapon node.
     * @return Weapon object.
     */
    private Weapon getWeapon(Node weaponNode) {
        Weapon weapon = new Weapon();
        Element qElement = (Element) weaponNode;

        // process question text
        Node wpNode = qElement.getElementsByTagName(XML.VISUALITY.value())
                .item(0);
        // set question text
        weapon.setVisuality((Visuality) wpNode.getChildNodes());

        // process answers
        NodeList aNodeList = qElement.getElementsByTagName(XML.value());
        for (int j = 0; j < aNodeList.getLength(); j++) {
            Answer answer = getAnswer(aNodeList.item(j));

            // add answer
            question.getAnswers().add(answer);
        }

        return question;
    }
}
