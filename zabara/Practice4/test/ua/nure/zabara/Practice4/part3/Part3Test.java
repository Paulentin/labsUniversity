package ua.nure.zabara.Practice4.part3;


import org.junit.Test;
import ua.nure.zabara.Practice4.Part3;

import static org.junit.Assert.*;


public class Part3Test {
	@Test
	public void checkerTest() throws Exception {
	}


	@Test
	public void main() throws Exception {
	}


	@Test
	public void getOutput() throws Exception {

		assertEquals("ы и л", Part3.getOutput("char"));

		assertEquals("яd sф фs ffa bcd фвыа", Part3.getOutput("String"));

	}
}