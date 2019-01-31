package com.model;


import javax.swing.ImageIcon;

import com.game.main;
import java.awt.*;

public class cursor {
    public final Image kursor = new ImageIcon("res/kursor.png").getImage();

    public int X;
    public int Y;

    public cursor(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X += x;
        if(X < 0 || X > main.game.getField().getSize()-1) {
            X -= x;
        }
    }

    public void setY(int y) {
        Y += y;
        if(Y < 0 || Y > main.game.getField().getSize()-1) {
            Y -= y;
        }
    }

    public Image getImageKursor() {
        return kursor;
    }
}
