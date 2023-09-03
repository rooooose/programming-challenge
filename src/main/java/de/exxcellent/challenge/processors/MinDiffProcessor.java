package de.exxcellent.challenge.processors;

import java.util.List;

/**
 * Implements the interfaces ListDifferenceCalculator ListElementFinder to calculate differences between columns
 * in a list of lists containing strings and finding elements based on minimum difference
 * in a specified column.
 *
 * @param <String> The type of elements stored in the lists.
 * @author Shir Frank <shir_fl@yahoo.fr>
 */
public class MinDiffProcessor implements ListDifferenceCalculator<String>, ListElementFinder<String>{

    /**
     * Calculates the numerical differences between two column values in a list of lists and adds a "Diff" column to each row.
     *
     * @param data The input list of lists containing string data.
     * @param colIndex1 The index of the first column for difference calculation.
     * @param colIndex2 The index of the second column for difference calculation.
     * @return A modified list of lists with a new "Diff" column containing the absolute differences.
     */
    @Override
    public List<List<String>> calculateDifferencesBetweenCols(List<List<String>> data, int colIndex1, int colIndex2) {

        data.get(0).add("Diff");

        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            int diff = Math.abs(Integer.parseInt(row.get(colIndex2)) - Integer.parseInt(row.get(colIndex1)));
            row.add(Integer.toString(diff));
        }
        return data;
    }
    
    
    /**
     * Finds the list element associated with the minimum difference in a specified comparison column.
     *
     * @param data The input list of lists containing string data.
     * @param comparisonColIdx The index of the column used for comparison to find the minimum difference.
     * @param elToFindColIdx The index of the column containing the element to be searched.
     * @return The element from the specified column that corresponds to the minimum difference in the comparison column.
     */
    @Override
    public String findListElement(List<List<String>> data, int comparisonColIdx, int elToFindColIdx) {

        int minDiff = Integer.parseInt(data.get(1).get(comparisonColIdx));
        String minDiffElement = data.get(1).get(elToFindColIdx);

        for(int i = 1; i < data.size(); i++ ){
            int DiffValue = Integer.parseInt(data.get(i).get(comparisonColIdx));
            if(DiffValue < minDiff){
                minDiff = DiffValue;
                minDiffElement = data.get(i).get(elToFindColIdx);
            }
        }
        return minDiffElement;
    }
    
}
