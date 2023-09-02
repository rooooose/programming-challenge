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
    private CsvReader csvReader = new CsvReader(dataSource);
    private MinDiffProcessor minDiffProcessor = new MinDiffProcessor();

    @BeforeEach
    void setUp() {
        dataSource = "src\\main\\resources\\de\\exxcellent\\challenge\\test.csv";

        expectedInitArr.add(Arrays.asList("Element","Max","Min"));
        expectedInitArr.add(Arrays.asList("el1","3","4"));
        expectedInitArr.add(Arrays.asList("el2","7","10"));

        expectedDiffArr.add(Arrays.asList("Element","Max","Min","Diff"));
        expectedDiffArr.add(Arrays.asList("el1","3","4","1"));
        expectedDiffArr.add(Arrays.asList("el2","7","10","3"));

        expectedMinEl = "el1";
    }

    @Test
    void testReadCsv() throws FileNotFoundException, IOException {
        assertEquals(expectedInitArr, csvReader.read(), "The result is not identical to the csv file content");
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