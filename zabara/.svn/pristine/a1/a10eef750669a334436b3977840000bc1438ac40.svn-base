package ua.nure.zabara.SummaryTask3;

import ua.nure.zabara.SummaryTask3.classes.Weapons;
import ua.nure.zabara.SummaryTask3.parsers.DOMController;
import ua.nure.zabara.SummaryTask3.parsers.SAXController;
import ua.nure.zabara.SummaryTask3.parsers.StAXController;
import ua.nure.zabara.SummaryTask3.settings.Settings;
import ua.nure.zabara.SummaryTask3.settings.XMLParser;
import ua.nure.zabara.SummaryTask3.util.Sorter;

import static ua.nure.zabara.SummaryTask3.settings.Settings.xmlFileName;

public class Main {
  /*  public static void usage() {
        System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
        System.out.println("java ua.nure.your_last_name.SummaryTask3.Main xmlFileName");
    }
*/
    public static void main(String[] args) throws Exception {
        /*if (args.length != 1) {
            usage();
            return;
        }
*/
        xmlFileName = "input.xml";
        System.out.println("Input ==> " + xmlFileName);

        ////////////////////////////////////////////////////////
        // DOM
        ////////////////////////////////////////////////////////

        // get
        DOMController domController = new DOMController();
        Weapons weapons = domController.getWeapons();

        // sort (case 1)
        Sorter.sortKnivesBY_ID(weapons);

        // save
        String outputXmlFile = "output.dom.xml";
        DOMController.saveToXML(weapons, outputXmlFile);
        System.out.println("Output ==> " + outputXmlFile);

        ////////////////////////////////////////////////////////
        // SAX
        ////////////////////////////////////////////////////////

        // get
        SAXController saxController = new SAXController();
        weapons = saxController.getWeapons();

        // sort  (case 2)
        Sorter.sortKnivesByLength(weapons);

        // save
        outputXmlFile = "output.sax.xml";

        // other way:
        DOMController.saveToXML(weapons, outputXmlFile);
        System.out.println("Output ==> " + outputXmlFile);

        ////////////////////////////////////////////////////////
        // StAX
        ////////////////////////////////////////////////////////

        // get
        StAXController staxController = new StAXController();
        weapons = staxController.getWeapons();

        // sort  (case 3)
        Sorter.sortKnivesByWidth(weapons);

        // save
        outputXmlFile = "output.stax.xml";
        DOMController.saveToXML(weapons, outputXmlFile);
        System.out.println("Output ==> " + outputXmlFile);
    }
}
