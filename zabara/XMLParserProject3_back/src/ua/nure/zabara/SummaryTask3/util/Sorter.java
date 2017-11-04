package ua.nure.zabara.SummaryTask3.util;

import java.util.Collections;
import java.util.Comparator;

import ua.nure.zabara.SummaryTask3.classes.KnifeType;
import ua.nure.zabara.SummaryTask3.classes.Weapons;
import ua.nure.zabara.SummaryTask3.settings.XMLParser;
import ua.nure.zabara.SummaryTask3.parsers.DOMController;


/**
 * Contains static methods for sorting.
 * 
 * @author paulentin
 *
 */
public class Sorter {

	// //////////////////////////////////////////////////////////
	// these are comparators
	// //////////////////////////////////////////////////////////

	/**
	 * Sorts questions by question text
	 */
	public static final Comparator<KnifeType> SORT_KNIVES_BY_ID = new Comparator<KnifeType>() {
		@Override
		public int compare(KnifeType o1, KnifeType o2) {
			return o1.getId().compareTo(o2.getId());
		}
	};

	/**
	 * Sorts questions by answers number.
	 */
	public static final Comparator<KnifeType> SORT_KNIVES_BY_LENGTH = new Comparator<KnifeType>() {
		@Override
		public int compare(KnifeType o1, KnifeType o2) {

			double lenOb1=o1.getVisual().getLength();
			double lenOb2=o2.getVisual().getLength();
			return (int) (lenOb1-lenOb2);
		}
	};

	/**
	 * Sorts answers.
	 */
	public static final Comparator<KnifeType> SORT_KNIVES_BY_WIDTH= new Comparator<KnifeType>() {
		@Override
		public int compare(KnifeType o1, KnifeType o2) {
			double wdthOb1=o1.getVisual().getWidth();
			double wdthOb2=o2.getVisual().getWidth();
			return (int) (wdthOb1-wdthOb2);
		}
	};


	// //////////////////////////////////////////////////////////
	// these methods take Test object and sort it
	// with according comparator
	// //////////////////////////////////////////////////////////

	public static final void sortKnivesBY_ID(Weapons weapons) {
		Collections.sort(weapons.getKnife(), SORT_KNIVES_BY_ID);
	}

	public static final void sortKnivesByLength(Weapons weapons) {
		Collections.sort(weapons.getKnife(), SORT_KNIVES_BY_LENGTH);
	}

	public static final void sortKnivesByWidth(Weapons weapons) {
		Collections.sort(weapons.getKnife(), SORT_KNIVES_BY_WIDTH);
	}


	public static void main(String[] args) throws Exception {
		// Test.xml --> Test object
		DOMController domController = new DOMController();
		XMLParser.validate();
		Weapons weapons;
		weapons=domController.getWeapons();

		System.out.println("====================================");
		System.out.println(weapons);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortKnivesBY_ID(weapons);
		System.out.println(weapons);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortKnivesByLength(weapons);
		System.out.println(weapons);
	}
}