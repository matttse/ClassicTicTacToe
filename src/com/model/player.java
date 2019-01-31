package com.model;


public class player {
    private final String name;
    private final figure figure;
    private int score;

    public  player (final String name, final figure figure) {
        this.figure = figure;
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public figure getFigure() {
        return figure;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
}
