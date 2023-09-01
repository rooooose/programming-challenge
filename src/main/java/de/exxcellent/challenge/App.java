package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.MinDiffProcessor;
import de.exxcellent.challenge.readers.CsvReader;
import java.util.ArrayList;

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
     */
    public static void main(String... args) {

        String dataSource = args[1];
        CsvReader csvReader = new CsvReader();
        MinDiffProcessor minDiffProcessor = new MinDiffProcessor();
        ArrayList<ArrayList<String>> data = csvReader.read(dataSource);

        if(args[1] == "weather.csv"){
            String dayWithSmallestTempSpread = minDiffProcessor.run(data);
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        }
        else if(args[1] == "football.csv"){
            String teamWithSmallestGoalSpread = minDiffProcessor.run(data);
            System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
        } 
           
    }
}
