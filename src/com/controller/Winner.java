package com.controller;

import java.awt.*;

import com.game.Main;
import com.model.*;

public class Winner {

    public Player getWinner (final Player players[]) {
        Player winner = null;
        int max = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getScore() > max) {
                max = players[i].getScore();
                winner = players[i];
            }
        }
        return winner;
    }

    public void searchTriple(final Point point, Figure figure, final Field field) throws InvalidPointException {
        int score = 0;
        int x = point.x;
        int y = point.y;

        for (int i = 0; i <= 4; i+=3) {

            if (figure == field.getFigure(new Point(x, y - 1)) &&
			        figure == field.getFigure(new Point(x, y - 2 + i))) {
			    score++;
			    setNullfigure(new Point(x, y - 1), field);
			    setNullfigure(new Point(x, y - 2 + i), field);
			}

            if (figure == field.getFigure(new Point(x + 1, y - 1)) &&
			        figure == field.getFigure(new Point(x + 2 - i, y - 2 + i))) {
			    score++;
			    setNullfigure(new Point(x + 1, y - 1), field);
			    setNullfigure(new Point(x + 2 - i, y - 2 + i), field);
			}

            if (figure == field.getFigure(new Point(x + 1, y)) &&
			        figure == field.getFigure(new Point(x + 2 - i, y))) {
			    score++;
			    setNullfigure(new Point(x + 1, y), field);
			    setNullfigure(new Point(x + 2 - i, y), field);
			}

            if (figure == field.getFigure(new Point(x + 1, y + 1)) &&
			        figure == field.getFigure(new Point(x + 2 - i, y + 2 - i))) {
			    score++;
			    setNullfigure(new Point(x + 1, y + 1), field);
			    setNullfigure(new Point(x + 2 - i, y + 2 - i), field);
			}

            if (figure == field.getFigure(new Point(x, y + 1)) &&
			        figure == field.getFigure(new Point(x, y + 2 - i))) {
			    score++;
			    setNullfigure(new Point(x, y + 1), field);
			    setNullfigure(new Point(x, y + 2 - i), field);
			}

            if (figure == field.getFigure(new Point(x - 1, y + 1)) &&
			        figure == field.getFigure(new Point(x - 2 + i, y + 2 - i))) {
			    score++;
			    setNullfigure(new Point(x - 1, y + 1), field);
			    setNullfigure(new Point(x - 2 + i, y + 2 - i), field);
			}

            if (figure == field.getFigure(new Point(x - 1, y)) &&
			        figure == field.getFigure(new Point(x - 2 + i, y))) {
			    score++;
			    setNullfigure(new Point(x - 1, y), field);
			    setNullfigure(new Point(x - 2 + i, y), field);
			}

            if (figure == field.getFigure(new Point(x - 1, y - 1)) &&
			        figure == field.getFigure(new Point(x - 2 + i, y - 2 + i))) {
			    score++;
			    setNullfigure(new Point(x - 1, y - 1), field);
			    setNullfigure(new Point(x - 2 + i, y - 2 + i), field);
			}
        }

        if (score != 0) {
            setNullfigure(point, field);
        }
        setScore(Main.game, figure, score);
    }

    private void setScore(final Game game, final Figure figure,  final int score) {
        final Player[] players = game.getPlayers();
        for(int i = 0; i < players.length ; i++) {
            if(players[i].getFigure().equals(figure)) {
                players[i].addScore(score);
            }
        }
    }

    private void setNullfigure(final Point point, final Field field) {
        try {
            field.setFigure(point, null);
            new Move().applyFigure(field, point, Figure.N);
        } catch (InvalidPointException e) {
            //TODO
        } catch (ExistingPointException e) {
            //TODO
        }
    }
}
