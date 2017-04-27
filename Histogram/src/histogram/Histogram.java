package histogram;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings("deprecation")
public class Histogram {

    // fields
    private File file;
    private HashMap<Character, Integer> frequencyTable;
    private StringBufferInputStream in;

    // constructor
    public Histogram(String fileName) {
        file = new File(fileName);
        frequencyTable = new HashMap<Character, Integer>();
        initTable();
    }

    // constructor #2, needed for unit tests
    public Histogram() {
        frequencyTable = new HashMap<Character, Integer>();
        initTable();
    }

    // the main method creates a Histogram and runs start()
    public static void main(String[] args) throws IOException {
        Histogram histogram = new Histogram("ambra.txt");
        histogram.start();
    }

    // initialising the frequencyTable with the chars A-Z and value 0 meaning 0 occurances
    private void initTable() {
        for (int i = 65; i < 91; i++) {
            frequencyTable.put((char) i, 0);
        }
    }

    private void start() throws IOException {
        readFromFile();
        writeStringToFile();
        writeIntegerToFile();
        writeIntToFile();
        createFile();
        printFrequencyTable();
        createFrequencyFile(getFrequencyList(frequencyTable));
    }

    /*
      reads all characters from file that are in a-z
      prints out the frequencyTable and calls the createFrequencyFile()
    */
    private void readFromFile() throws IOException {
        FileReader fileReader = new FileReader(file);
        prepareFrequencySave(fileReader);
        fileReader.close();
    }

    /*
      saves each ascii-character from the ambra.txt, as long as there are characters
     */
    private void prepareFrequencySave(FileReader fileReader) throws IOException {
        while (fileReader.ready()) {
            int asciiValue = fileReader.read();
            saveAsNewASCII(asciiValue);
        }
    }

    public void readFromInputStream(String input) {
        StringBufferInputStream in = new StringBufferInputStream(input);
        for (int i = 1; i < in.available(); i++) {
            int asciiValue = in.read();
            saveAsNewASCII(asciiValue);
        }
    }

    /*
        normalizing: converts lower case letters to upper case by changing ascii-value
     */
    private void saveAsNewASCII(int asciiValue) {
        if ((asciiValue > 96 && asciiValue < 123) || asciiValue > 64 && asciiValue < 91) {
            if (asciiValue > 96 && asciiValue < 123)
                asciiValue -= 32;
            char actualCharacter = (char) asciiValue;
            save(actualCharacter);
        }
    }


    //saves the normalized uppercase characters inte the frequencyTable HashMap
    private void save(char actualCharacter) {
        Character c = actualCharacter;
        // ab hier workaround zum updaten der hashmap
        Integer value = frequencyTable.get(c);
        // counting the amount of used characters in the frequencyTable:
        frequencyTable.put(actualCharacter, value + 1);
        //das normale ++inkrement hat hier nicht funktioniert
    }

    // returns a String that contains the frequencyTable in Character - value pairs
    private String getFrequencyList(HashMap<Character, Integer> frequencyTable) {
        String frequencyList = "";
        //TODO Erklärung dieser Syntax
        Iterator it = frequencyTable.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            frequencyList += (pair.getKey() + " - " + pair.getValue() + "\n");
            it.remove();
        }
        return frequencyList;
    }

    // creates a new file that contains the String it is given
    private void createFrequencyFile(String frequencyList) throws IOException {
        PrintWriter frequencyOut = new PrintWriter("frequencyOutput.txt");
        frequencyOut.write(frequencyList);
        frequencyOut.close();
    }

    private void printFrequencyTable() {
        System.out.println(frequencyTable + "\n");
        String f = getFrequencyList(frequencyTable);
        System.out.println(f);
    }

    /*
      Methoden für Aufgabe 2 - StringToFile, IntegerToFile, intToFIle,
      methods for assignment 2
     */
    private void writeStringToFile() throws IOException {
        PrintWriter printOut = new PrintWriter("stringOutput.txt");
        printOut.write("Test"); // starts the OutputStream
        printOut.close(); // closes the - " - and is necessary to complete the writing process
    }

    private void writeIntegerToFile() throws IOException {
        Integer number = 1234;
        FileWriter writeOut = new FileWriter("IntegerOutput.txt");
        writeOut.write(number.toString());
        writeOut.close();
    }

    private void writeIntToFile() throws IOException {
        int i = 4321;
        FileWriter intOut = new FileWriter("intOutput.txt");
        // valueOf returns the String of an int
        intOut.write(String.valueOf(i));
        intOut.close();
    }

    //how to create a file
    private void createFile() throws IOException {
        File file = new File("createFile.txt");
        file.createNewFile();
    }

    // a getter method for the HashMap, will be needed for JUnit tests
    public HashMap<Character, Integer> getFrequencyTable() {
        return frequencyTable;
    }

}

