package com.aor.g608.model.game;

import com.aor.g608.gui.FileReader;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.item.Pellet;
import com.aor.g608.model.item.PowerUp;
import com.aor.g608.viewer.game.MapViewer;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements GhostDatabase{

    private final int height;
    private final int width;
    private GhostDatabase database;
    private ArrayList<Wall> walls;
    private ArrayList<Ghost> ghosts;
    private ArrayList<PowerUp> powerUps;
    private ArrayList<Pellet> pellets;
    private final GUI gui;
    private final Player player;
    private final MapViewer mapViewer;
    private final FileReader file;


    private int score = 0;


    public Map(int width, int height, GUI gui) throws FileNotFoundException {
        player = new Player(12, 21);
        this.height = height;
        this.width = width;
        this.gui = gui;

        file = new FileReader("src/main/resources/maps/map.txt");
        mapViewer = new MapViewer(gui, this);

        createMap();

    }


    public void createMap(){
        ArrayList<Wall> walls = new ArrayList<>();
        ArrayList<Pellet> pellets = new ArrayList<>();
        ArrayList<PowerUp> powerUps = new ArrayList<>();

        List<String> lines = file.getMap();
        for(int row = 0; row < lines.size(); row++){
            String line = lines.get(row);
            char[] ch = new char[line.length()];
            for(int i = 0; i < line.length(); i++){
                ch[i] = line.charAt(i);
            }
            for(int col = 0; col < line.length(); col++){
                switch(ch[col]){
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                    case 'g':
                    case 'h':
                        walls.add(new Wall(col, row)); break;
                    case '.':
                        pellets.add(new Pellet(col, row)); break;
                    case '-':
                        powerUps.add(new PowerUp(col, row)); break;
                }
            }
        }
        this.walls = walls;
        this.pellets = pellets;
        this.powerUps = powerUps;
        this.ghosts = createGhosts();
    }

    public void GhostFinder(GhostDatabase database){
        this.database = database;
    }

    public boolean findGhost(String color){
        List<Ghost> allGhosts = database.getAllGhosts();

        for (Ghost ghost : allGhosts){
            if(ghost.getPosition().equals(color))
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
        if(canPlayerMove(position)) {
            player.setPosition(position);
            retrievePellets();
        }
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


    public List<Wall> getWalls() {
        return walls;
    }


    private ArrayList<Ghost> createGhosts() {
        ArrayList<Ghost> ghosts = new ArrayList<>();
        Ghost red = new Ghost(15, 14);
        ghosts.add(red);
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
    /*
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
            else return ghost.getPosition();
        }
    }
    */

    public Position moveGhost(Ghost ghost) {
        Random r = new Random();

        while(true) {
            Position pRight = new Position(ghost.getPosition().getX() + r.nextInt(3)-1,ghost.getPosition().getY());
            Position pLeft = new Position(ghost.getPosition().getX(), ghost.getPosition().getY() + r.nextInt(3) - 1);
            if(canGhostMove(pRight)) return pRight;
            if(canGhostMove(pLeft)) return pLeft;
        }

    }

    public void moveGhosts(){
        for(Ghost ghost : ghosts){
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

    public void draw() throws IOException{
        mapViewer.draw();
        gui.refresh();
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

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public ArrayList<PowerUp> getPowerUps() {
        return powerUps;
    }

    public Player getPlayer() {
        return player;
    }
}


