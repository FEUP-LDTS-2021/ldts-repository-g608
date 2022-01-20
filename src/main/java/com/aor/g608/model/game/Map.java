package com.aor.g608.model.game;

import com.aor.g608.gui.FileReader;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.item.Pellet;
import com.aor.g608.model.item.PowerUp;
import com.aor.g608.viewer.game.MapViewer;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Map implements GhostDatabase{
    private final int height;
    private final int width;
    private GhostDatabase database;
    private final List<Wall> walls;
    private final List<Ghost> ghosts;
    private final List<PowerUp> powerUps;
    private final List<Pellet> pellets;
    private final  Player player;
    private MapViewer mapViewer;
    private FileReader file;
    private GUI gui;

    private int score = 0;

    private char[][] map = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',}, //28
            {'#','-','p','p','p','p','p','p','p','p','p','p','p','#','#','p','p','p','p','p','p','p','p','p','p','p','-','#',},
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
            {'#','-','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','-','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',}
    };      //31


    public Map(int width, int height, GUI gui) {
        player = new Player(12, 21);
        this.height = height;
        this.width = width;
        this.gui = gui;
        mapViewer = new MapViewer(gui);

        walls = createWalls();
        ghosts = createGhosts();
        pellets = createPellets();
        powerUps = createPowerUps();

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


    public void draw() {



    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void  addWall(Wall wall){
        walls.add(wall);
    }


    public List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[j].length; j++) {
                if(map[i][j] == '#') {
                    walls.add(new Wall(j, i));
                }
            }
        }
        return walls;
    }

    public List<PowerUp> createPowerUps(){
        List<PowerUp> powerUps = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[j].length; j++) {
                if(map[i][j] == '-') {
                    Position powerUpPosition = new Position(j, i);
                    powerUps.add(new PowerUp(j,i));
                }
            }
        }
        return powerUps;
    }

    public List<Pellet> createPellets() {
        List<Pellet> pellets = new ArrayList<>();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[j].length; j++) {
                if(map[i][j] == 'p') {
                    pellets.add(new Pellet(j, i));
                }
            }
        }
        return pellets;
    }


    private List<Ghost> createGhosts() {
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Position redPosition = new Position(10, 14);
        Ghost red = new Ghost(redPosition,"red");
        ghosts.add(red);
        Position cyanPosition = new Position(12, 16);
        Ghost cyan = new Ghost(cyanPosition,"cyan");
        ghosts.add(cyan);
        Position orangePosition = new Position(14, 18);
        Ghost orange = new Ghost(orangePosition,"orange");
        ghosts.add(orange);
        Position pinkPosition = new Position(16, 20);
        Ghost pink = new Ghost(pinkPosition,"pink");
        ghosts.add(pink);
        return ghosts;
    }

    public boolean canGhostMove(Position position) {
        for(Wall wall: walls) {
            if (position.equals(wall.getPosition())) {
                return false;
            }
        }

        for(Ghost ghost : ghosts) {
            if(position.equals(ghost.getPosition())) {
                return false;
            }
        }


        return true;
    }




    public Position moveGhost(Ghost ghost) {
        Position p1, p2;
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();
        int x1 = x, x2 = x, y1 = y, y2 = y;

        while(true) {
            if (ghost.getPosition().getX() < player.getPosition().getX()) {
                x1 = x + 1;
            } else if (ghost.getPosition().getX() > player.getPosition().getX()) {
                x1 = x - 1;
            }
            p1 = new Position(x1, y1);
            if (x1 != x && this.canGhostMove(p1)) return p1;

            //check y
            if (ghost.getPosition().getY() < player.getPosition().getY()) {
                y2 = y + 1;
            } else if (ghost.getPosition().getY() > player.getPosition().getY()) {
                y2 = y - 1;
            }
            p2 = new Position(x2, y2);
            if (y2 != y && this.canGhostMove(p2)) return p2;
            else return ghost.getPosition(); //if cant move neither stop and move on the next turn
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

    private void retrievePellets() {
        for (Pellet pellet : pellets)
            if (player.getPosition().equals(pellet.getPosition())) {
                pellets.remove(pellet);
                setScore(score + 10);
                break;
            }
    }


    public boolean retrievePowerUps() {
        for(PowerUp powerUp : powerUps)
            if(player.getPosition().equals(powerUp.getPosition())){
                powerUps.remove(powerUp);
                return true;
            }
        return false;
    }

    @Override
    public List<Ghost> getAllGhosts() {
        return ghosts;
    }

    public String getScore(){
        return Integer.toString(score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Pellet> getPellets() {
        return pellets;
    }
}