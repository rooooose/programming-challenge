package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.MinDiffProcessor;
import de.exxcellent.challenge.readers.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String... args) {

        String dataSource = "src/main/resources/de/exxcellent/challenge/" + args[1];
        CsvReader csvReader = new CsvReader();
        List<List<String>> data;
        int diffCol1Id;
        int diffCol2Id;
        try {
            data = new ArrayList<>(csvReader.read(dataSource));
            MinDiffProcessor minDiffProcessor = new MinDiffProcessor();
            // System.out.println(data);
            
            if("weather.csv".equals(args[1])){
                // System.out.println("OUI");
                diffCol1Id = 1;
                diffCol2Id = 2;
                // List<List<String>> dataWithDifferences = minDiffProcessor.calculateDifferencesBetweenCols(data, diffCol1Id, diffCol2Id);
                // System.out.println(dataWithDifferences);
                String dayWithSmallestTempSpread = minDiffProcessor.run(data, diffCol1Id, diffCol2Id);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            }
            else if("football.csv".equals(args[1])){
                diffCol1Id = 5;
                diffCol2Id = 6;
                String teamWithSmallestGoalSpread = minDiffProcessor.run(data, diffCol1Id, diffCol2Id);
                System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
            } 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
}
