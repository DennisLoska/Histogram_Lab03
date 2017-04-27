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
	
	@Test
	public void testCharacterCounting() {
		String in = "aaaa";
		Histogram histo = new Histogram();
		histo.readFromInputStream(in);
		Integer t = histo.getFrequencyTable().get('A');
		assertEquals(2, t.intValue());
	}

}
