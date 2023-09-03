package de.exxcellent.challenge.processors;

import java.util.List;

/**
 * Defines a contract for finding list elements based on specific criteria
 * within a list of lists containing elements of type T.
 *
 * @param <T> The type of elements stored in the lists.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
public interface ListElementFinder<T> {

    /**
     * Finds and returns the specified column element from a list based on a specified comparison column.
     *
     * @param data The input list of lists containing elements of type T.
     * @param comparisonColIdx The index of the column used for comparison to determine the target element.
     * @param elToFindColIdx  The index of the column containing the element to be searched.
     * @return The element from the specified element column that corresponds to the criteria defined by the
     *         comparison column.
     */
    String findListElement(List<List<T>> data, int comparisonColIdx, int elToFindColIdx);
    
}
