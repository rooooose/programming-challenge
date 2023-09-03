package de.exxcellent.challenge.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implements the DataReader interface to read data from a CSV file
 * and represent it as a list of lists containing elements of type String.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
public class CsvReader implements DataReader<String> {

    
    /** 
     * Reads and processes data from a CSV file and returns it as a list of lists.
     *
     * @param dataSource The path to the CSV file to be read.
     * @return A list of lists containing elements of type String representing the data read from the CSV file.
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public List<List<String>> read(String dataSource) throws FileNotFoundException, IOException {
        
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(new ArrayList<>(Arrays.asList(values)));
            }
        }
        return records;
    }


   
}
