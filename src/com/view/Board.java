package com.view;

import com.game.Main;
import com.model.Field;
import com.model.Figure;
import com.model.InvalidPointException;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public final Field field = Main.game.getField();

    private final Image xImage = new ImageIcon("com/view/res/xImage.png").getImage();
    private final Image oImage = new ImageIcon("com/view/res/oImage.png").getImage();
//    private final Image nuller = new ImageIcon("res/nuller.png").getImage();
    private final Image selectorSquare = new ImageIcon("res/selectorSquare.png").getImage();

    private final int countLine = Main.sizeField - 1;
    private int  widthLine = 50 / countLine;
    private final int space = (500 - widthLine*countLine) / Main.sizeField ;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.BLACK);
        paintLine(g2);
//        paintFigure(g2);
        paintCursor(g2);
    }

    public void paintLine(Graphics2D g2) {
        if (widthLine < 1) {
            widthLine = 1;
        }

        int pos = space;
        for(int i = 0; i < countLine; i++) {
            g2.fillRoundRect(pos, 0, widthLine, 500, 10, 10);
            g2.fillRoundRect(0, pos, 495, widthLine, 10, 10);
            pos += space + widthLine;
        }
    }

    public void paintFigure(Graphics2D g2) throws InvalidPointException {
        int xFigure;
        int yFigure;
        int widthFigure;

        for(int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                Figure figure;
                figure = field.getFigure(new Point(y, x));
                xFigure = x*space+widthLine*(x+1);
                yFigure = y*space+widthLine*(y+1);
                widthFigure =  ((space-widthLine*2));
                if (figure == Figure.X) {
                    g2.drawImage(xImage, xFigure, yFigure, widthFigure, widthFigure, null);
                }
                if (figure == Figure.O) {
                    g2.drawImage(oImage, xFigure, yFigure, widthFigure, widthFigure, null);
                }
//                if (figure == Figure.N) {
//                    g2.drawImage(nuller, xFigure, yFigure, widthFigure, widthFigure, null);
//                }
            }
        }
    }

    public void paintCursor(Graphics2D g2) {
        int x = Main.game.getCursor().getX();
        int y = Main.game.getCursor().getY();
        x = x * space + widthLine * x;
        y = y * space + widthLine * y;
        int widthCursor = space;
        g2.drawImage(selectorSquare, x, y, widthCursor,  widthCursor,  null);
    }
}
