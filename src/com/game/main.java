package com.game;

import com.view.board;
import com.view.inputCapture;
import com.model.*;

public class main {

    public static game game;
    public static int sizeField;

    public static void main(final  String[] args) {

        final String name0 = inputCapture.inputPlayerNameWV("-X-");
        final String name1 = inputCapture.inputPlayerNameWV("-O-");

        sizeField = inputCapture.inputSizeFieldWV();

        final player[] players = new player[2];
        players[0] = new player(name0, figure.X);
        players[1] = new player(name1, figure.O);

        game = new game(players, new field(sizeField), "XO", new cursor(0,0));

//        final WindowsView wv = new WindowsView();
        
//        while (game.isEnd) {
//            wv.loop();
//            wv.repaint();
//        }
    }
}
