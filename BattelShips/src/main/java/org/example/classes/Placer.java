package org.example.classes;

import java.util.Scanner;

public class Placer {
    int shipsWhitSize2 = 1;
    int shipsWhitSize3 = 2;
    int shipsWhitSize4 = 2;
    int shipsWhitSize5 = 1;
    int shipsTotal = shipsWhitSize2 + shipsWhitSize3 + shipsWhitSize4 + shipsWhitSize5;

    Grid grid;

    int placedShips = 0;
    int startCoordinatX;
    int startCoordinatY;
    int stepX = 0;
    int stepY = 0;
    int shipSice;
    int shipTyp = 0;

    public Placer(Grid grid) {

        this.grid = grid;
    }

    public void placeShipsTerminal() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipsTotal; i++) {
            System.out.println("Available ships: \nLenght 2: " + shipsWhitSize2 + "\nLenght 3: " + shipsWhitSize3 + "\nLenght 4: " + shipsWhitSize4 + "\nLenght 5: " + shipsWhitSize5);

            for (;;) {
                System.out.println("Pleace selct a available ship");
                setShipSice(scanner.nextInt());

                if (shipAvailable(shipSice)) break;

                System.out.println("Ship is not available!");
            }
            reduceShip(shipSice);

            for (;;) {
                grid.printGridShips();
                System.out.println("Place select the start Position");

                System.out.print("X:");
                setStartCoordinatX(scanner.nextInt());

                System.out.print("Y:");
                setStartCoordinatY(scanner.nextInt());

                System.out.print("Select the direktion Down[D], Right[R]");
                String direction = scanner.next();

                switch (direction) {
                    case "D" -> setStepY(1);
                    case "R" -> setStepX(1);
                }

                if (positionForShipFree()) break;
            }

            placeShip();
            grid.printGridShips();
        }
    }

    private boolean shipAvailable(int shipSize) {
        return switch (shipSize) {
            case 2 -> (shipsWhitSize2 > 0);
            case 3 -> (shipsWhitSize3 > 0);
            case 4 -> (shipsWhitSize4 > 0);
            case 5 -> (shipsWhitSize5 > 0);
            default -> false;
        };
    }

    private void reduceShip(int shipSize) {
        switch (shipSize) {
            case 2 -> shipsWhitSize2--;
            case 3 -> shipsWhitSize3--;
            case 4 -> shipsWhitSize4--;
            case 5 -> shipsWhitSize5--;
        }
    }

    private boolean positionForShipFree() {
        //Check if the ship is in the grid
        if (
                startCoordinatX < 0 ||
                startCoordinatX >= grid.gridBroad ||
                startCoordinatY < 0 ||
                startCoordinatY >= grid.gridHight ||
                startCoordinatX + shipSice * stepX < 0 ||
                startCoordinatX + shipSice * stepX >= grid.gridBroad ||
                startCoordinatY + shipSice * stepY < 0 ||
                startCoordinatY + shipSice * stepY >= grid.gridHight
        ) {
            return false;
        }

        //Check all field which have to be free
        for (int i = -1; i < (shipSice-1)* stepY +3-1; i++) {

            //When the field is outside the grid, it get ignored
            if (startCoordinatY +i < 0 || startCoordinatY +i >= grid.gridHight) continue;

            for (int k = -1; k < (shipSice-1)* stepX +3-1; k++) {

                //When the field is outside the grid, it get ignored
                if (startCoordinatX +k < 0 || startCoordinatX +k >= grid.gridBroad) continue;

                //return false when a field is not free
                if (grid.getPositionShipsGrid(startCoordinatX + k,startCoordinatY +i) > -2) {
                    return false;
                }
            }
        }

        return true;
    }

    private void placeShip() {
        grid.addShipToList(new Ship(shipSice, shipTyp, startCoordinatX, startCoordinatY, stepX, stepY));

        for (int i = 0; i < shipSice; i++) {
            grid.changeFieldOnShipsGrid(startCoordinatX + stepX * i, startCoordinatY + stepY * i, placedShips);
        }

        placedShips++;
    }

    public void setAllShipsTo0() {
        setShipsWhitSize2(0);
        setShipsWhitSize3(0);
        setShipsWhitSize4(0);
        setShipsWhitSize5(0);
    }

    public void setShipsWhitSize2(int shipsWhitSize2) {
        this.shipsWhitSize2 = shipsWhitSize2;
        shipsTotal = shipsWhitSize2 + shipsWhitSize3 + shipsWhitSize4 + shipsWhitSize5;
    }

    public void setShipsWhitSize3(int shipsWhitSize3) {
        this.shipsWhitSize3 = shipsWhitSize3;
        shipsTotal = shipsWhitSize2 + shipsWhitSize3 + shipsWhitSize4 + shipsWhitSize5;
    }

    public void setShipsWhitSize4(int shipsWhitSize4) {
        this.shipsWhitSize4 = shipsWhitSize4;
        shipsTotal = shipsWhitSize2 + shipsWhitSize3 + shipsWhitSize4 + shipsWhitSize5;
    }

    public void setShipsWhitSize5(int shipsWhitSize5) {
        this.shipsWhitSize5 = shipsWhitSize5;
        shipsTotal = shipsWhitSize2 + shipsWhitSize3 + shipsWhitSize4 + shipsWhitSize5;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
        this.stepY = 0;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
        this.stepX = 0;
    }

    public void setStartCoordinatX(int startCoordinatX) {
        this.startCoordinatX = startCoordinatX;
    }

    public void setStartCoordinatY(int startCoordinatY) {
        this.startCoordinatY = startCoordinatY;
    }

    public void setShipSice(int shipSice) {
        this.shipSice = shipSice;
    }

    public void setShipTyp(int shipTyp) {
        this.shipTyp = shipTyp;
    }

    public void placeShipsAutomatik() {
        setAllShipsTo0();

        setShipSice(2);
        setStartCoordinatX(1);
        setStartCoordinatY(1);
        setStepX(1);
        placeShip();

        setShipSice(5);
        setStartCoordinatX(1);
        setStartCoordinatY(3);
        setStepX(1);
        placeShip();

        setShipSice(3);
        setStartCoordinatX(1);
        setStartCoordinatY(5);
        setStepY(1);
        placeShip();

        setShipSice(3);
        setStartCoordinatX(3);
        setStartCoordinatY(5);
        setStepY(1);
        placeShip();
    }
}
