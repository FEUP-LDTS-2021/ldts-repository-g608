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
        Position position = new Position(10, 10);
        player = new Player(position, "yellow"); // it doesn't mean will exactly be "yellow", but instead the color's code
        this.height = height;
        this.width = width;
        //walls = createWalls(); will be overwritten by Andre's code
        // ghosts = createGhosts(); need to fix createGhosts() 1st

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

    public void removeWall(Wall wall){
        walls.remove(wall);
    }

    /*
    * This will be overwritten by André's code
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
    */

    /*
    * This method needs to fixed
    private List<Ghost> createGhosts() {
        Random random = new Random();
        ArrayList<Ghost> ghosts = new ArrayList<>();
        for(int i=0; i<4; i++){
            Ghost newGhost = new Ghost(random.nextInt(width-2) + 1, random.nextInt(height-2)+1, "Yellow");
            if(!ghosts.contains(newGhost) && !newGhost.getPosition().equals(player.getPosition()))
                ghosts.add(newGhost);
        }
        return ghosts;
    }
    */


    @Override
    public List<Ghost> getAllGhosts() {
        return ghosts;
    }
}