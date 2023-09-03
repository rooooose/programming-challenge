package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import de.exxcellent.challenge.processors.MinDiffProcessor;
import de.exxcellent.challenge.readers.*;

/**
 * JUnit 5 test case.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
class AppTest {

    private String dataSource;
    private List<List<String>> expectedInitArr = new ArrayList<>();
    private List<List<String>> expectedDiffArr = new ArrayList<>();
    private String expectedMinEl;
    private CsvReader csvReader;
    private MinDiffProcessor minDiffProcessor;

    @BeforeEach
    void setUp() {
        dataSource = "src/main/resources/de/exxcellent/challenge/test.csv";

        expectedInitArr.add(new ArrayList<>(Arrays.asList("Element","Max","Min")));
        expectedInitArr.add(new ArrayList<>(Arrays.asList("el1","10","7")));
        expectedInitArr.add(new ArrayList<>(Arrays.asList("el2","4","3")));

        expectedDiffArr.add(new ArrayList<>(Arrays.asList("Element","Max","Min","Diff")));
        expectedDiffArr.add(new ArrayList<>(Arrays.asList("el1","10","7","3")));
        expectedDiffArr.add(new ArrayList<>(Arrays.asList("el2","4","3","1")));

        expectedMinEl = "el2";

        csvReader = new CsvReader();
        minDiffProcessor = new MinDiffProcessor();
    }

    @Test
    void testReadCsv() throws FileNotFoundException, IOException {
        assertEquals(expectedInitArr, csvReader.read(dataSource), "The result is not identical to the csv file content");
    }

    @Test
    void testCalcDiffs() {
        assertEquals(expectedDiffArr, minDiffProcessor.calculateDifferencesBetweenCols(expectedInitArr, 2, 1), "The array doesn't contain the differences");
    }

    @Test
    void testfindMinEl() {
        assertEquals(expectedMinEl, minDiffProcessor.findListElement(expectedDiffArr, 3, 0), "The minimum difference element is wrong");
    }

    @Test
    void runWeather() {
        App.main("--weather", "weather.csv");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}