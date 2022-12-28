package org.example.classes;

public class Grid {
    int gridHight = 8;
    int gridBroad = gridHight;

    public Grid() {
    }

    public Grid(int gridHight, int gridBroad) {
        this.gridHight = gridHight;
        this.gridBroad = gridBroad;
    }

    public void setGridHight(int gridHight) {
        this.gridHight = gridHight;
    }

    public void setGridBroad(int gridBroad) {
        this.gridBroad = gridBroad;
    }

    public void printGrid() {
        System.out.println("Test");
    }

}
