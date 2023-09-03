package de.exxcellent.challenge.processors;

import java.util.List;

public class MinDiffProcessor implements ListDifferenceCalculator<String>, ListElementFinder<String>{

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
