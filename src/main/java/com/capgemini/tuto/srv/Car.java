package com.capgemini.tuto.srv;

public class Car {

    private Orientation orientation;

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    // Before refactoring.
    public void rotate() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EST;
        }
        else if (orientation == Orientation.EST) {
            orientation = Orientation.SOUTH;
        }
        else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        }
        else if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }

    /*
    // After refactoring.
    public void rotate() {
        RotationStrategy strategy = Car::rotateClockwise;
        orientation = strategy.apply(orientation);
    }

    public static Orientation rotateClockwise(Orientation initial) {
        int x = initial.ordinal() + 1;
        if (x >= Orientation.values().length) {
            x = 0;
        }
        return Orientation.values()[x];
    }
     */

}
