package com.controller;

import com.model.Field;
import com.model.Figure;
import java.awt.*;
public class CurrentMove {
	
    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                if (field.getFigure(new Point(x,y)) != null)
				    countFigure++;
            }
        }
        if(countFigure == field.getSize()*field.getSize())
            return null;

        if (countFigure % 2 ==0)
            return Figure.X;
        return Figure.O;
    }
    
}
