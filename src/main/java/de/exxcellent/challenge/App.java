package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.MinDiffProcessor;
import de.exxcellent.challenge.readers.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        CsvReader csvReader = new CsvReader(dataSource);
        MinDiffProcessor minDiffProcessor = new MinDiffProcessor();
        List<List<String>> data;
        try {
            data = csvReader.read();
            // System.out.println(data);

            if(args[1] == "weather.csv"){
                String dayWithSmallestTempSpread = minDiffProcessor.run(data);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            }
            else if(args[1] == "football.csv"){
                String teamWithSmallestGoalSpread = minDiffProcessor.run(data);
                System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
            } 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
}
