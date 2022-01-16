package com.aor.g608.model.game;

import com.aor.g608.Player;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements GhostDatabase{
    private int height;
    private int width;
    private GhostDatabase database;
    private List<Wall> walls;
    private List<Ghost> ghosts;
    private Player player;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Map(int width, int height) {
        player = new Player(15, 15);
        this.height = height;
        this.width = width;

        walls = createWalls();
        ghosts = createGhosts();

    }

    public void GhostFinder(GhostDatabase database){
        this.database = database;
    }

    public boolean findGhost(String color){
        List<Ghost> allGhosts = database.getAllGhosts();

        for (Ghost ghost : allGhosts){
            if(ghost.getColor().equals(color))
                return true;
        }
        return false;
    }

    public boolean canPlayerMove(Position position) {
        return (position.getX() >= 0 && position.getX() < width) &&
                (position.getY() >= 0 && position.getY() < height) &&
                !walls.contains(new Wall(position.getX(), position.getY()));
    }


    public void movePlayer(Position position){
        if(canPlayerMove(position)) player.setPosition(position);
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
        screen.setBackgroundColor(TextColor.ANSI.BLACK);
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        screen.enableModifiers(SGR.BOLD);

        player.draw(screen);

        for(Wall wall : walls)
            wall.draw(screen);

        for(Ghost ghost : ghosts)
            ghost.draw(screen);
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void  addWall(Wall wall){
        walls.add(wall);
    }


    private List<Wall> createWalls() throws ArrayIndexOutOfBoundsException{

        char[][] map = {
                {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',}, //28
                {'#','p','p','p','p','p','p','p','p','p','p','p','p','#','#','p','p','p','p','p','p','p','p','p','p','p','p','#',},
                {'#','p','#','#','#','#','p','#','#','#','#','#','p','#','#','p','#','#','#','#','#','p','#','#','#','#','p','#',},
                {'#','p','#','#','#','#','p','#','#','#','#','#','p','#','#','p','#','#','#','#','#','p','#','#','#','#','p','#',},
                {'#','p','#','#','#','#','p','#','#','#','#','#','p','#','#','p','#','#','#','#','#','p','#','#','#','#','p','#',},
                {'#','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','#',},
                {'#','p','#','#','#','#','p','#','#','p','#','#','#','#','#','#','#','#','p','#','#','p','#','#','#','#','p','#',},
                {'#','p','#','#','#','#','p','#','#','p','#','#','#','#','#','#','#','#','p','#','#','p','#','#','#','#','p','#',},
                {'#','p','p','p','p','p','p','#','#','p','p','p','p','#','#','p','p','p','p','#','#','p','p','p','p','p','p','#',},
                {'#','#','#','#','#','#','p','#','#','#','#','#',' ','#','#',' ','#','#','#','#','#','p','#','#','#','#','#','#',},
                {' ',' ',' ',' ',' ','#','p','#','#','#','#','#',' ','#','#',' ','#','#','#','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {' ',' ',' ',' ',' ','#','p','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#','p','#',' ',' ',' ',' ',' ',},
                {'#','#','#','#','#','#','p','#','#',' ','#','#','#','#','#','#','#','#',' ','#','#','p','#','#','#','#','#','#',},
                {'#','p','p','p','p','p','p','p','p','p','p','p','p','#','#','p','p','p','p','p','p','p','p','p','p','p','p','#',},
                {'#','p','#','#','#','#','p','#','#','#','#','#','p','#','#','p','#','#','#','#','#','p','#','#','#','#','p','#',},
                {'#','p','#','#','#','#','p','#','#','#','#','#','p','#','#','p','#','#','#','#','#','p','#','#','#','#','p','#',},
                {'#','p','p','p','#','#','p','p','p','p','p','p','p',' ',' ','p','p','p','p','p','p','p','#','#','p','p','p','#',},
                {'#','#','#','p','#','#','p','#','#','p','#','#','#','#','#','#','#','#','p','#','#','p','#','#','p','#','#','#',},
                {'#','#','#','p','#','#','p','#','#','p','#','#','#','#','#','#','#','#','p','#','#','p','#','#','p','#','#','#',},
                {'#','p','p','p','p','p','p','#','#','p','p','p','p','#','#','p','p','p','p','#','#','p','p','p','p','p','p','#',},
                {'#','p','#','#','#','#','#','#','#','#','#','#','p','#','#','p','#','#','#','#','#','#','#','#','#','#','p','#',},
                {'#','p','#','#','#','#','#','#','#','#','#','#','p','#','#','p','#','#','#','#','#','#','#','#','#','#','p','#',},
                {'#','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','#',},
                {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',}
        };      //31

        List<Wall> walls = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[j].length; j++) {
                if(map[i][j] == '#')
                    walls.add(new Wall(j,i));
            }
        }
        return walls;
    }

    private List<Ghost> createGhosts() {
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Ghost red = new Ghost(10,16,"red");
        ghosts.add(red);
        Ghost cyan = new Ghost(12,16,"cyan");
        ghosts.add(cyan);
        Ghost orange = new Ghost(14,16,"orange");
        ghosts.add(orange);
        Ghost pink = new Ghost(16,16,"pink");
        ghosts.add(pink);
        return ghosts;
    }

    public boolean canGhostMove(Position position) {
        boolean b = true;
        for(Wall wall: walls) {
            if(wall.getPosition().equals(position)) {
                b = false;
            }
        }
        return b;
    }


    public void moveGhosts() {
        for(Ghost ghost : ghosts) {
            if(canGhostMove(ghost.getPosition()))
            ghost.setPosition(ghost.move(this));
        }
    }

   // public boolean checkGhostCollision() { }

    @Override
    public List<Ghost> getAllGhosts() {
        return ghosts;
    }
}