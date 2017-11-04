package ua.nure.zabara.Practice4.part2;

import static org.junit.Assert.*;

import org.junit.Test;
import ua.nure.zabara.Practice4.Part2;

public class Part2Test {
	private static final String RAW_DATA = "part2.txt";
	@Test
	public void generateTest() throws Exception {
		Part2.generate();
	}

	@Test
	public void readTest() {
		try {
			writeTest();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void writeTest() throws Exception {
		String checkStr="5686 989965 55 -38 65";
		Part2.write(checkStr,RAW_DATA);
		Part2.read(RAW_DATA);
		assertEquals(checkStr,Part2.read(RAW_DATA));
	}

	@Test
	public void sortAndwriteTest() throws Exception {

		Part2.sortAndwrite();
		assertEquals("-38 55 65 5686 989965",Part2.read("part2_sorted.txt"));
	}

	@Test
	public void mainTest() throws Exception {

        writeTest();
        readTest();

        sortAndwriteTest();

	}



}
