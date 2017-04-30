package histogram;

import static org.junit.Assert.*;
import org.junit.Test;

public class HistogramTest {

	@Test
	public void testHashMapInitialization() {
		Histogram hist = new Histogram("ambra.txt"); 
		Integer v = hist.getFrequencyTable().get('A');
		assertEquals(0,v.intValue());
		assertNull(hist.getFrequencyTable().get('%'));
	}

    /*
     Test-case for exercise 4: StringInputStream
    */
	@Test
	public void testCharacterCounting() {
		String in = "aaaaaaaaaa";
		Histogram histo = new Histogram();
		histo.readFromInputStream(in);
		Integer t = histo.getFrequencyTable().get('A');
		assertEquals(10, t.intValue());
	}

	/*
     Test-case for exercise 5: getMostFreqString
    */
	@Test
	public void testMostFreqString(){
		String in = "qawseeeedrftgzhujikolpqawsedrftgzhujikolkzgdegazu";
		Histogram histo = new Histogram();
		histo.readFromInputStream(in);
		String mostFreqChar = histo.getMostFreqString(histo.getFrequencyTable());
		String testString = "Most frequent character -> " + "E" + " - " + "6" + " occurences\n";
		assertTrue(mostFreqChar.equals(testString));
	}


    @Test
    public void testCorrectCounting(){


    }

}
