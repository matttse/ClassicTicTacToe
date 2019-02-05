package com.controller;

import com.model.Cursor;
import com.model.ExistingPointException;
import com.model.Field;
import com.model.Figure;
import com.model.InvalidPointException;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;

import static com.game.Main.game;


public class KeyboardInput extends KeyAdapter {

    public final Cursor cursor = game.getCursor();

    private CurrentMove currentMove = new CurrentMove();
    private Winner winner = new Winner();
    private Move movetracker = new Move();

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
                cursor.setX(0);
                cursor.setY(-1);
        }
        else if (key == KeyEvent.VK_DOWN) {
                cursor.setX(0);
                cursor.setY(1);
        }
        else if (key == KeyEvent.VK_LEFT) {
                cursor.setX(-1);
                cursor.setY(0);
        }
        else if (key == KeyEvent.VK_RIGHT) {
                cursor.setX(1);
                cursor.setY(0);
        }
        else if (key == KeyEvent.VK_SPACE) {
            int x = cursor.getX();
            int y = cursor.getY();

            final Field field = game.getField();
            final Figure currentFigure = currentMove.currentMove(field);

            Point point = new Point(y,x);
            try {
                movetracker.applyFigure(field,point,currentFigure);
                winner.searchTriple(point, currentFigure, field);
            } catch (InvalidPointException e2) {
                JOptionPane.showMessageDialog(null, "Invalid Point Selected!");
            } catch (ExistingPointException e2) {
                JOptionPane.showMessageDialog(null, "Position Taken!");
            }
        }
    }
}
