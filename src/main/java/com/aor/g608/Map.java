package com.aor.g608;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Map {
    private int height;
    private int width;
    private Player player;


    public Map(int widht, int height) {
        player = new Player(10, 10);
        this.height = height;
        this.width = widht;
    }


    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        screen.enableModifiers(SGR.BOLD);
        player.draw(screen);
    }
}