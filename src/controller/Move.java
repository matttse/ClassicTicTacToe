package controller;
import java.awt.*;

import model.*;

public class Move {
    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, ExistingPointException {

        if (field.getFigure(point) != null) {
            throw new ExistingPointException();
        }
        field.setFigure(point, figure);
        Game.step++;
    }
}
