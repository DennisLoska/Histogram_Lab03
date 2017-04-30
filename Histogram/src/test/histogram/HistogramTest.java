package test.histogram;

import histogram.Histogram;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dennis on 24.04.2017.
 */
public class HistogramTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
    public void testHashMapInitialization() {
        Histogram hist = new Histogram("ambra.txt");
        Integer v = hist.getFrequencyTable().get('A');
        assertEquals(0, v.intValue());
        assertNull(hist.getFrequencyTable().get('%'));
    }

    @Test
    public void testCharacterCounting() {
        String in = "aaaa";
        Histogram histo = new Histogram();
        histo.readFromInputStream(in);
        Integer t = histo.getFrequencyTable().get('A');
        assertEquals(4, t.intValue());
    }

}