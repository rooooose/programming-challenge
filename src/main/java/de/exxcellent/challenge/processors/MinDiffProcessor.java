package de.exxcellent.challenge.processors;

import java.util.Comparator;
import java.util.List;

public class MinDiffProcessor implements ListDifferenceProcessor<String>, ListElementFinder<String>{

    @Override
    public List<List<String>> calculateDifferencesBetweenCols(List<List<String>> data, int colIndex1, int colIndex2) {
        data.get(0).add("Diff");
        for (int i = 1; i < data.size(); i++) {
            List<String> row = data.get(i);
            int diff = Math.abs(Integer.parseInt(row.get(colIndex2)) - Integer.parseInt(row.get(colIndex1)));
            row.add(Integer.toString(diff));
        }
        System.out.println(data);
        return data;
    }
    
    @Override
    public String findListElement(List<List<String>> data, Comparator<String> comp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findListElement'");
    }

    public String run(List<List<String>> data, int colIndex1, int colIndex2){
        List<List<String>> dataWithDifferences = calculateDifferencesBetweenCols(data, colIndex1, colIndex2);
        return null;
    }
    
}
