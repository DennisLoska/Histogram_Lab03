package histogram;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Dennis on 24.04.2017.
 */
public class HistogramSystem {
	
	public HistogramSystem() {
		
	}
    
	public static void main(String[] args) throws IOException {
        System.out.println("Test:");
        HistogramSystem hs = new HistogramSystem();
        hs.read();
    }
	
	public void read() throws IOException {
		Path path = Paths.get("example.txt");
		byte[] b = Files.readAllBytes(path);

		for(int i = 0 ; i < b.length; i++) {
		  // printing the characters one by one
		  System.out.println((char) b[i]); 
		}
		ByteArrayInputStream bInput = new ByteArrayInputStream(b);
	}

}
