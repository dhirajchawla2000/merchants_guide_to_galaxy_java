package roman;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guide.merchant.roman.RomanNumber;

public class RomanNumberTest {

	@Test
	public void validRomanNumberTest1() throws Exception {
		assertTrue(RomanNumber.isValidRomanNumber("I"));
	}

	@Test
	public void validRomanNumberTest2() throws Exception {
		assertTrue(RomanNumber.isValidRomanNumber("MCMXLIV"));
	}

	@Test
	public void invalidRomanNumberTest() throws Exception {
		assertFalse(RomanNumber.isValidRomanNumber("VV"));
	}

	@Test
	public void validRomanNumberToArabicTest1() throws Exception {
		assertEquals(RomanNumber.romanNumberToArabic("I"), 1);
	}

	@Test
	public void validRomanNumberToArabicTest2() throws Exception {
		assertEquals(RomanNumber.romanNumberToArabic("MCMXLIV"), 1944);
	}

	@Test
	public void invalidRomanNumberToArabicTest() throws Exception {
		assertEquals(RomanNumber.romanNumberToArabic("VV"), -1);
	}

	@Test
	public void invalidRomanIIIVToArabicTest() throws Exception {
		assertEquals(RomanNumber.romanNumberToArabic("IIIV"), -1);
	}

}
