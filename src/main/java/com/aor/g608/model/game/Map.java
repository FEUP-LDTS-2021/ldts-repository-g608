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

public class Map implements GhostDatabase{
    private int height;
    private int width;
    private GhostDatabase database;
    private List<Wall> walls;
    private List<Ghost> ghosts;
    private List<Pellet> pellets;
    private Player player;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Map(int width, int height) {
        player = new Player(12, 21);
        this.height = height;
        this.width = width;

        walls = createWalls();
        ghosts = createGhosts();
        pellets = createPellets();

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
        if(canPlayerMove(position)){
            player.setPosition(position);
            retrievePellets();
        }
        else System.out.println("not moving there");
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

        for(Pellet pellet : pellets)
            pellet.draw(screen);

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


    private List<Wall> createWalls() {

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

    private List<Pellet> createPellets() {


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

        List<Pellet> pellets = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[j].length; j++) {
                if(map[i][j] == 'p')
                    pellets.add(new Pellet(j,i));
            }
        }
        return pellets;
    }

    private List<Ghost> createGhosts() {
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Ghost red = new Ghost(10,14,"red");
        ghosts.add(red);
        Ghost cyan = new Ghost(12,16,"cyan");
        ghosts.add(cyan);
        Ghost orange = new Ghost(14,18,"orange");
        ghosts.add(orange);
        Ghost pink = new Ghost(16,20,"pink");
        ghosts.add(pink);
        return ghosts;
    }

    public boolean canGhostMove(Position position) {
        boolean b = true;
        for(Wall wall: walls) {
            if(position.equals(wall.getPosition())) {
                b = false;
            }
            for(Ghost ghost : ghosts) {
                if(position.equals(ghost.getPosition())) {
                    b = false;
                }
            }
        }
        return b;
    }

    public Position moveGhost(Ghost ghost) {
        Position p;
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();

        while(true) {
            //check x
            if(ghost.getPosition().getX() < player.getPosition().getX()) {
                x = ghost.getPosition().getX() + 1;
            }
            else if(ghost.getPosition().getX() > player.getPosition().getX()) {
                x = ghost.getPosition().getX() - 1;
            }
            //check y
            if(ghost.getPosition().getY() < player.getPosition().getY()) {
                y = ghost.getPosition().getY() + 1;
            }
            else if(ghost.getPosition().getY() > player.getPosition().getY()) {
                y = ghost.getPosition().getY() - 1;
            }

            p = new Position(x,y);
            if(this.canGhostMove(p)) return p;
            else return ghost.getPosition();
        }
    }

    public void moveGhosts() {
        for(Ghost ghost : ghosts) {
            ghost.setPosition(moveGhost(ghost));
        }
    }

   public boolean checkGhostEatsPlayer() {
        for(Ghost ghost : ghosts) {
            if(ghost.getPosition().equals(player.getPosition())) return true;
        }
        return false;
   }

    //player gets pellets [still a work in progress]
    private void retrievePellets() {
        for (Pellet pellet : pellets)
            if (player.getPosition().equals(pellet.getPosition())) {
                pellets.remove(pellet);
                break;
            }
    }


    @Override
    public List<Ghost> getAllGhosts() {
        return ghosts;
    }

}