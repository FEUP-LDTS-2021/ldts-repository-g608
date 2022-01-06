package com.aor.g608.model.game;

import com.aor.g608.Player;
import com.aor.g608.model.game.Wall;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int height;
    private int width;

    private List<Wall> walls;

    private Player player;


    public Map(int width, int height) {
        player = new Player(10, 10);
        this.height = height;
        this.width = width;

        walls = createWalls();
    }

    public void movePlayer(Position position){
        player.setPosition(position);
    }


    public Position moveUp() {
        return new Position(player.getPosition().getX(), player.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(player.getPosition().getX(), player.getPosition().getY() + 1);
    }

    public Position moveLeft() {
        return new Position(player.getPosition().getX()-1, player.getPosition().getY());
    }

    public Position moveRight() {
        return new Position(player.getPosition().getX()+1, player.getPosition().getY());
    }


    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        screen.enableModifiers(SGR.BOLD);

        player.draw(screen);

        for(Wall wall : walls)
            wall.draw(screen);
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c=0; c < width; c++){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }

        for(int r=0; r < height; r++){
            walls.add(new Wall(0, r));
            walls.add(new Wall(width-1, r));
        }

        return walls;
    }
}