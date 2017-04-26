package histogram;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Histogram {
	
	private File file;
	private HashMap<Character, Integer> frequencyTable;	//Eine Tabelle der Buchstaben und ihrer Häufigkeit
	
	public Histogram(String fileName){
		file = new File(fileName);
		frequencyTable = new HashMap<Character, Integer>();
		initTable();
	}

	//eine  getterMethod für die HashMap -> wird später vom Unit Test benötigt
	public HashMap<Character, Integer> getFrequencyTable(){
		return frequencyTable;
	}
	
	// Initialisierung der Häufigkeitstabelle
	// der Ausdruck "(char) i" liefert den character and der Stelle i der ascii Tabelle
	private void initTable(){
		for(int i=65; i<91; i++){
			frequencyTable.put((char) i, 0);
		}
	}
	
	// main Methode, erstellt ein Histogramm und führt die start() aus 
	public static void main(String[] args){
		Histogram histogram = new Histogram("ambra.txt");
		histogram.read();
	}
	
	/*// start() als Zwichenschritt, startet die read(), noch erweiterbar (prints, mkfile etc)
	private void read(){
		read();
	}*/
	
	private void read(){
		FileReader fileReader = null;
			try {
				fileReader = new FileReader(file);
				while(fileReader.ready()){
					int asciiValue = fileReader.read();
					if((asciiValue>96 && asciiValue<123) || asciiValue>64 && asciiValue<91){
						if(asciiValue>96 && asciiValue<123){
							asciiValue = asciiValue-32;
						}
					char actualCharacter = (char)asciiValue;
					save(actualCharacter);			
					}
				}
			} catch (IOException e) {
				if(e instanceof FileNotFoundException){
					System.out.println("File Not Found.");
				}
				e.printStackTrace();
			}
		try{
			fileReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(frequencyTable);
	}
	
	private void save(char actualCharacter){
		Character c = new Character(actualCharacter);	
		Integer value = frequencyTable.get(c);
		frequencyTable.remove(actualCharacter);
		frequencyTable.put(actualCharacter, value.intValue()+1); // das normale ++inkrement hat hier nicht funktioniert
	}
}
