package de.exxcellent.challenge.processors;

import java.util.Comparator;
import java.util.List;

public interface ListElementFinder<T> {

    String findListElement(List<List<T>> data, Comparator<T> comp);
    
}
