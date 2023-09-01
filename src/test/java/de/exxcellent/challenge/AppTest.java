package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import de.exxcellent.challenge.processors.MinDiffProcessor;
import de.exxcellent.challenge.readers.*;

/**
 * JUnit 5 test case.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
class AppTest {

    private String dataSource;
    private ArrayList<ArrayList<String>> expectedInitArr = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> expectedDiffArr = new ArrayList<ArrayList<String>>();
    private String expectedMinEl;
    private CsvReader csvReader = new CsvReader();
    private MinDiffProcessor minDiffProcessor = new MinDiffProcessor();

    @BeforeEach
    void setUp() {
        dataSource = "src\\main\\resources\\de\\exxcellent\\challenge\\test.csv";

        expectedInitArr.add(new ArrayList<String>(Arrays.asList("Element","Max","Min")));
        expectedInitArr.add(new ArrayList<String>(Arrays.asList("el1","3","4")));
        expectedInitArr.add(new ArrayList<String>(Arrays.asList("el2","7","10")));

        expectedDiffArr.add(new ArrayList<String>(Arrays.asList("Element","Max","Min","Diff")));
        expectedDiffArr.add(new ArrayList<String>(Arrays.asList("el1","3","4","1")));
        expectedDiffArr.add(new ArrayList<String>(Arrays.asList("el2","7","10","3")));

        expectedMinEl = "el1";
    }

    @Test
    void testReadCsv() {
        assertEquals(expectedInitArr, csvReader.read(dataSource), "The result is not identical to the csv file content");
        // assertTrue(Arrays.deepEquals(expectedInitArr, csvReader.read(dataSource)), "the result contains all the content of the csv in a nested array");
    }

    @Test
    void testCalcDiffs() {
        assertEquals(expectedDiffArr, minDiffProcessor.calculateDifferences(expectedInitArr), "The array doesn't contain the differences");
    }

    @Test
    void testfindMinEl() {
        assertEquals(expectedMinEl, minDiffProcessor.findListElement(expectedDiffArr), "Minimum difference element should be el1");
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