package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    int gridHight = 8;
    int gridBroad = gridHight;

    List<ArrayList<Integer>> shipGrid = new ArrayList<>();
    List<ArrayList<Integer>> shotGrid = new ArrayList<>();

    ArrayList<Ship> shipsList = new ArrayList<>();
    public Grid() {
        for ( int i = 0; i < gridHight; i++) {
            shipGrid.add(new ArrayList<>());

            for (int k = 0; k < gridBroad; k++) {
                shipGrid.get(i).add(-2);
            }
        }

        for ( int i = 0; i < gridHight; i++) {
            shotGrid.add(new ArrayList<>());

            for (int k = 0; k < gridBroad; k++) {
                shotGrid.get(i).add(0);
            }
        }
    }

    public void setGridHight(int gridHight) {
        this.gridHight = gridHight;
    }

    public void setGridBroad(int gridBroad) {
        this.gridBroad = gridBroad;
    }

    public void printGridShips() {
        shipGrid.forEach(System.out::println);
    }

    public void printGridShots() {
        shotGrid.forEach(System.out::println);
    }


    public void placeShips() {
        Placer placer = new Placer(this);
        placer.placeShipsTerminal();

        printGridShips();
    }

    public int getPositionShipsGrid(int x, int y) {
        return shipGrid.get(y).get(x);
    }

    public void addShipToList(Ship ship) {
        shipsList.add(ship);
    }

    public void changeFieldOnShipsGrid(int x, int y, Integer newValue) {
        shipGrid.get(y).set(x, newValue);
    }

    public void changeFieldOnShotsGrid(int x, int y, int newValue) {
        shotGrid.get(y).set(x, newValue);
    }

}
