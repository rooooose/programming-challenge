package de.exxcellent.challenge.processors;

import java.util.List;

public interface ListElementFinder<T> {

    String findListElement(List<List<T>> data, int comparisonColIdx, int elToFindColIdx);
    
}
