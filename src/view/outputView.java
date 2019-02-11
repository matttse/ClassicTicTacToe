package view;

import mainGame.Main;
import controller.CurrentMove;
import controller.Move;
import controller.Winner;
import model.Field;
import model.Figure;
import model.Game;
import model.Player;
import model.ExistingPointException;
import model.InvalidPointException;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class outputView {

    private CurrentMove currentMoveController = new CurrentMove();
    private Winner winnerController = new Winner();
    private Move moveController = new Move();

    public void show(final Game game) {

        System.out.format("Game name %s\n", game.getName());

        final Field field = game.getField();

        for(int x = 0; x < field.getSize(); x++) {
            outLine(field);
            System.out.print("|");
            for(int y = 0; y < field.getSize(); y++) {
                final Figure figure;
                try {
                    figure = field.getFigure(new Point(x, y));
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
                System.out.print(figure != null ? figure : " ");
                System.out.print("|");
            }
            System.out.println();
        }
        outLine(field);
    }

    public boolean move(final Game game) {

        final Field field = game.getField();
        final Player winner = winnerController.getWinner(Main.game.getPlayers());
        final Figure currentFigure = currentMoveController.currentMove(field);

        if (winner != null) {
            System.out.format("Winner is - %s", winner.getName());
            return false;
        }

        if (currentFigure == null) {
            System.out.println("No winner!");
            return false;
        }

        System.out.format("This Turn For - %s\n",searchPlayerName(game,currentFigure));

        final Point point = askPoint();

        try {
            moveController.applyFigure(field,point,currentFigure);
        } catch (InvalidPointException e) {
            System.out.println("Invalid Point");
        } catch (ExistingPointException e) {
            System.out.println("Position Taken!");
        }
        return true;
    }

    private Point askPoint() {

        return new Point(askCoordinate("Y")-1, askCoordinate("X")-1);

    }

    private int askCoordinate(final String coordinateName) {

        System.out.format("Input %s", coordinateName);

        final Scanner in = new Scanner(System.in);

        try {
            return in.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("point does not exist!");
            return askCoordinate(coordinateName);
        }

    }

    private void outLine(Field field) {
        for(int i = 0; i < field.getSize(); i++) {
            System.out.print("--");
        }
        System.out.println("-");
    }

    private String searchPlayerName(Game game, Figure figure) {
        final Player[] players = game.getPlayers();

        for(int i = 0; i < players.length ; i++) {
            if(players[i].getFigure().equals(figure)) {
                return players[i].getName();
            }
        }
        return  null;
    }
}