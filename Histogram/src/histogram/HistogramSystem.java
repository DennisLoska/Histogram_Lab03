package histogram;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Dennis on 24.04.2017.
 */
public class HistogramSystem {
	
	public HistogramSystem() {
		
	}
    
	public static void main(String[] args) throws IOException {
        HistogramSystem hs = new HistogramSystem();
        hs.read();
    }
	
	public void read() throws IOException {
		System.out.println("char – frequency");
		Path path = Paths.get("example.txt");
		byte[] b = Files.readAllBytes(path);
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		// read source & count character frequency
		for (int i = 0 ; i < b.length; i++) {
			if ((char) b[i] != '\n') { // ignore linebreaks
				int frequency = 0;
				try { frequency = map.get((char) b[i]); } catch (NullPointerException e) {}
				map.put((char) b[i], frequency + 1);
			}
		}
		
		// print results
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " ––> " + entry.getValue() + "x");
		}
		
		ByteArrayInputStream bInput = new ByteArrayInputStream(b);
	}

}
