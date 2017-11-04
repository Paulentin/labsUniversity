package ua.nure.zabara.SummaryTask3;

import ua.nure.zabara.SummaryTask3.controller.DOMController;
import ua.nure.zabara.SummaryTask3.controller.SAXController;
import ua.nure.zabara.SummaryTask3.controller.STAXController;
import ua.nure.zabara.SummaryTask3.entity.Weapons;
import ua.nure.zabara.SummaryTask3.util.Sorter;

/**
 * Entry point for st3 example (simple version).
 * @author D.Kolesnikov
 *
 */
public class Main {
	public static void usage() {
		System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
		System.out.println("java ua.nure.zabara.SummaryTask3.ua.nure.zabara.SummaryTask3.Main xmlFileName");
	}
	
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			usage();
			return;
		}
		
		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);
		
		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////
		
		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		Weapons weapons = domController.getWeapons();

		// sort (case 1)
		Sorter.sortWeaponsByType(weapons);
		
		// save
		String outputXmlFile = "output.dom.xml";
		DOMController.saveToXML(weapons, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////
		
		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		weapons = saxController.getWeapons();
		
		// sort  (case 2)
		Sorter.sortQuestionsByLength(weapons);
		
		// save
		outputXmlFile = "output.sax.xml";
		
		// other way: 
		DOMController.saveToXML(weapons, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
		
		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////
		
		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		weapons = staxController.getWeapons();
		
		// sort  (case 3)
		Sorter.sortAnswersByCountry(weapons);
		
		// save
		outputXmlFile = "output.stax.xml";
		DOMController.saveToXML(weapons, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
	}

}