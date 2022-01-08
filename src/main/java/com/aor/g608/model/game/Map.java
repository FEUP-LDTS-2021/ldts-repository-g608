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


    private List<Wall> walls = new ArrayList<>();
    private List<Ghost> ghosts;

    private Player player;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Map(int width, int height) {
        player = new Player(10, 10);
        this.height = height;
        this.width = width;


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
        screen.setBackgroundColor(TextColor.ANSI.BLUE);
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

    public void removeWall(Wall wall){
        walls.remove(wall);
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

    /*
    private List<Ghost> createMonsters() {
        Random random = new Random();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        int a = 2;
        for(int i=0; i<5; i++){
            Ghost newmonster = new Ghost(width-a, height-a, "YELLOW");
            a += 2;
            if(!ghosts.contains(newmonster) && !newmonster.getPosition().equals(player.getPosition()))
                ghosts.add(newmonster);
        }
        return ghosts;
    }
    */


    @Override
    public List<Ghost> getAllGhosts() {
        return ghosts;
    }
}