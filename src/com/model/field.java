package com.model;

import java.awt.Point;

public class field {

    public final static int MIN_COORDINATE = 0;

    private final figure[][] field;

    public final int fieldSize;

    public field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public figure getFigure(final Point point) {//throws InvalidPointException {
//            if (!checkPoint(point))
//            throw new InvalidPointException();

        return  field[point.x][point.y];
    }

    public void setFigure(final Point point, final figure figure) {//throws InvalidPointException {
//        if (!checkPoint(point))
//            throw new InvalidPointException();
//        else
            field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
