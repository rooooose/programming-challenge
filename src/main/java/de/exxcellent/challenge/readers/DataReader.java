package de.exxcellent.challenge.readers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Defines a contract for reading and processing data from a specified data source
 * and returning it as a list of lists containing elements of type T.
 *
 * @param <T> The type of elements to be read and processed.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
public interface DataReader<T> {

    /**
     * Reads and processes data from the specified data source and returns it as a list of lists.
     *
     * @param dataSource The source of the data to be read, which could be a file path, URL, or other data source.
     * @return A list of lists containing elements of type `T` representing the data read from the source.
     * @throws FileNotFoundException 
     * @throws IOException          
     */
    List<List<T>> read(String dataSource) throws FileNotFoundException, IOException;
    
}
