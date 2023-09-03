package de.exxcellent.challenge.processors;

import java.util.List;

public interface ListDifferenceCalculator<T> {

    List<List<T>> calculateDifferencesBetweenCols(List<List<T>> data, int colIndex1, int colIndex2);
}