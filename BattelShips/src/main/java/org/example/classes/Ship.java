package org.example.classes;

public class Ship {
    int size;
    int typ;

    int startCoordinatX;
    int startCoordinatY;

    int stepCoordinatX;
    int StepCoordinatY;

    public Ship(int size, int typ, int startCoordinatX, int startCoordinatY, int stepCoordinatX, int stepCoordinatY) {
        this.size = size;
        this.typ = typ;
        this.startCoordinatX = startCoordinatX;
        this.startCoordinatY = startCoordinatY;
        this.stepCoordinatX = stepCoordinatX;
        this.StepCoordinatY = stepCoordinatY;
    }
}
