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
        String in = "aaabac";
        Histogram histo = new Histogram();
        histo.readFromInputStream(in);
        int a = histo.getFrequencyTable().get('A');
        int b = histo.getFrequencyTable().get('B');
        int c = histo.getFrequencyTable().get('C');
        assertEquals(4, a);
        assertEquals(1, b);
        assertEquals(1, c);
    }

}