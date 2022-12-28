package org.example.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    int gridHight = 8;
    int gridBroad = gridHight;

    //IntStream.rangeClosed(1, gridHight) =
    //.boxed() =
    //.map(i -> Collections.nCopies(gridBroad, 0)) =
    //.collect(Collectors.toList()) =
    List<List<Integer>> shipGrid = IntStream.rangeClosed(1, gridHight).boxed().map(i -> Collections.nCopies(gridBroad, 0)).collect(Collectors.toList());
    List<List<Integer>> shotGrid = IntStream.rangeClosed(1, gridHight).boxed().map(i -> Collections.nCopies(gridBroad, 0)).collect(Collectors.toList());
    // https://www.techiedelight.com/initialize-list-of-lists-java/
    public Grid() {

    }

    public void setGridHight(int gridHight) {
        this.gridHight = gridHight;
    }

    public void setGridBroad(int gridBroad) {
        this.gridBroad = gridBroad;
    }

    public void printGrid() {
        shipGrid.forEach(System.out::println);
        shotGrid.forEach(System.out::println);
    }

}
