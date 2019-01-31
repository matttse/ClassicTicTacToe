package com.model;

import java.awt.Cursor;

public class game {

    public static int step = 0;

    private final player[] players;
    private final field field;
    private final String name;
    private final cursor cursor;
    
    public Boolean isEnd;

    public game(final player[] players, final field field, final String name, final cursor cursor) {
        this.players = players;
        this.field = field;
        this.name = name;
        this.cursor = cursor;
        this.isEnd = true;
    }

    public player[] getPlayers() {
        return players;
    }

    public field getField() {
        return field;
    }

    public String getName() {
        return name;
    }

    public cursor getCursor() {
        return cursor;
    }

    public Boolean getEnd() {
        return isEnd;
    }
}
