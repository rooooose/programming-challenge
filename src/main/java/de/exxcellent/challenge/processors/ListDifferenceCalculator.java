package de.exxcellent.challenge.processors;

import java.util.List;

/**
 * Defines a contract for calculating differences between columns
 * in a list of lists containing elements of type T.
 *
 * @param <T> The type of elements stored in the lists.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
public interface ListDifferenceCalculator<T> {

    /**
     * Calculates the differences between two columns in a list of lists and returns a modified list of lists
     * with the differences added as a new column.
     *
     * @param data The input list of lists containing elements of type T.
     * @param colIndex1 The index of the first column for difference calculation.
     * @param colIndex2 The index of the second column for difference calculation.
     * @return A modified list of lists with a new column containing the calculated differences.
     */
    List<List<T>> calculateDifferencesBetweenCols(List<List<T>> data, int colIndex1, int colIndex2);
}