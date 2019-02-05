package com.game;

import com.view.Board;
import com.view.InputCapture;
import com.model.*;

public class Main {

    public static Game game;
    public static int sizeField;

    public static void main(final  String[] args) {

        final String name0 = InputCapture.inputPlayerNameWV("-X-");
        final String name1 = InputCapture.inputPlayerNameWV("-O-");

        sizeField = InputCapture.inputSizeFieldWV();

        final Player[] players = new Player[2];
        players[0] = new Player(name0, Figure.X);
        players[1] = new Player(name1, Figure.O);

        game = new Game(players, new Field(sizeField), "XO", new Cursor(0,0));

//        final WindowsView wv = new WindowsView();
        
//        while (game.isEnd) {
//            wv.loop();
//            wv.repaint();
//        }
    }
}
