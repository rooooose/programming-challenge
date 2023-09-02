package de.exxcellent.challenge.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader implements DataReader {

    //create constructor with dataSource as attribute, bufferedReader and fileReader
    private String dataSource;

    public CsvReader(String filepath){
        dataSource = filepath;
    }

    @Override
    public List<List<String>> read() throws FileNotFoundException, IOException {
        
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataSource))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }


   
}
