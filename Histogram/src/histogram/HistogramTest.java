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

}
