package com.controller;
import com.model.*;

import java.awt.*;

public class Move {
    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, ExistingPointException {

        if (field.getFigure(point) != null) {
            throw new ExistingPointException();
        }
        field.setFigure(point, figure);
        Game.step++;
    }
}
