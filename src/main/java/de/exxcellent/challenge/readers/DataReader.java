package de.exxcellent.challenge.readers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DataReader {

    List<List<String>> read(String dataSource) throws FileNotFoundException, IOException;
    
}
