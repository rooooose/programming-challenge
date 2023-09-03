package de.exxcellent.challenge;

import de.exxcellent.challenge.processors.MinDiffProcessor;
import de.exxcellent.challenge.readers.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
        int diffCol1Idx;
        int diffCol2Idx;
        int comparisonColIdx;
        int elToFindColIdx;

        try {
            data = new ArrayList<>(csvReader.read(dataSource));
            MinDiffProcessor minDiffProcessor = new MinDiffProcessor();
            comparisonColIdx = data.get(0).size();
            elToFindColIdx = 0;
            
            if("weather.csv".equals(args[1])){
                diffCol1Idx = 1;
                diffCol2Idx = 2;
                
                List<List<String>> dataWithTempSpreads = minDiffProcessor.calculateDifferencesBetweenCols(data, diffCol1Idx, diffCol2Idx);
                String dayWithSmallestTempSpread = minDiffProcessor.findListElement(dataWithTempSpreads, comparisonColIdx, elToFindColIdx);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            }
            else if("football.csv".equals(args[1])){
                diffCol1Idx = 5;
                diffCol2Idx = 6;

                List<List<String>> dataWithGoalSpreads = minDiffProcessor.calculateDifferencesBetweenCols(data, diffCol1Idx, diffCol2Idx);
                String teamWithSmallestGoalSpread = minDiffProcessor.findListElement(dataWithGoalSpreads, comparisonColIdx, elToFindColIdx);
                System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
            } 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
    }
}
