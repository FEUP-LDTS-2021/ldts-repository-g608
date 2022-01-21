package com.aor.g608.model.game;

import com.aor.g608.gui.FileReader;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.model.item.Pellet;
import com.aor.g608.model.item.PowerUp;
import com.aor.g608.model.wall.*;
import com.aor.g608.viewer.game.MapViewer;
import com.aor.g608.viewer.game.MusicPlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    private final int height;
    private final int width;
    private GhostDatabase database;
    private ArrayList<Wall> walls;
    private Ghost redGhost;
    private Ghost pinkGhost;
    private Ghost cyanGhost;
    private Ghost orangeGhost;
    private ArrayList<PowerUp> powerUps;
    private ArrayList<Pellet> pellets;
    private ArrayList<VerticalWall> verticalWalls;
    private ArrayList<CurvedDownRightWall> curvedDownRightWalls;
    private ArrayList<CurvedDownLeftWall> curvedDownLeftWalls;
    private ArrayList<CurvedUpperLeftWall> curvedUpperLeftWalls;
    private ArrayList<CurvedUpperRightWall> curvedUpperRightWalls;
    private final GUI gui;
    private final Player player;
    private final MapViewer mapViewer;
    private final FileReader file;


    private Integer score = 0;


    public Map(int width, int height, GUI gui) throws FileNotFoundException {
        player = new Player(14, 17);
        this.height = height;
        this.width = width;
        this.gui = gui;

        file = new FileReader("src/main/resources/maps/map.txt");
        mapViewer = new MapViewer(gui, this);

        createMap();

    }


    public void createMap(){
        ArrayList<Wall> walls = new ArrayList<>();
        ArrayList<CurvedDownRightWall> curvedDownRightWalls = new ArrayList<>();
        ArrayList<CurvedDownLeftWall> curvedDownLeftWalls = new ArrayList<>();
        ArrayList<CurvedUpperLeftWall> curvedUpperLeftWalls = new ArrayList<>();
        ArrayList<CurvedUpperRightWall> curvedUpperRightWalls = new ArrayList<>();
        ArrayList<VerticalWall> verticalWalls = new ArrayList<>();
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
                        curvedDownLeftWalls.add(new CurvedDownLeftWall(col, row)); break;
                    case 'b':
                        curvedDownRightWalls.add(new CurvedDownRightWall(col, row)); break;
                    case 'c':
                        curvedUpperLeftWalls.add(new CurvedUpperLeftWall(col, row)); break;
                    case 'd':
                        curvedUpperRightWalls.add(new CurvedUpperRightWall(col, row)); break;
                    case 'e':
                        walls.add(new Wall(col, row)); break;
                    case 'f':
                        verticalWalls.add(new VerticalWall(col, row)); break;
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
        this.redGhost = createGhosts();
        this.pinkGhost = createPinkGhost();
        this.cyanGhost = createCyanGhost();
        this.orangeGhost = createOrangeGhost();
        this.curvedUpperRightWalls = curvedUpperRightWalls;
        this.curvedDownRightWalls = curvedDownRightWalls;
        this.curvedUpperLeftWalls = curvedUpperLeftWalls;
        this.curvedDownLeftWalls = curvedDownLeftWalls;
        this.verticalWalls = verticalWalls;
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
        for(VerticalWall verticalWall : verticalWalls) {
            if (position.equals(verticalWall.getPosition())) {
                return false;
            }
        }

        for(Wall wall: walls) {
            if (position.equals(wall.getPosition())) {
                return false;
            }
        }

        if (check(position)) return false;
        return true;


    }

    private boolean check(Position position) {
        for(CurvedUpperRightWall curvedUpperRightWall : curvedUpperRightWalls) {
            if (position.equals(curvedUpperRightWall.getPosition())) {
                return true;
            }
        }

        for(CurvedDownLeftWall curvedDownLeftWall  : curvedDownLeftWalls) {
            if (position.equals(curvedDownLeftWall.getPosition())) {
                return true;
            }
        }

        for(CurvedDownRightWall curvedDownRightWall  : curvedDownRightWalls) {
            if (position.equals(curvedDownRightWall.getPosition())) {
                return true;
            }
        }

        for(CurvedUpperLeftWall curvedUpperLeftWall  : curvedUpperLeftWalls) {
            if (position.equals(curvedUpperLeftWall.getPosition())) {
                return true;
            }
        }
        return false;
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

    public Ghost getRedGhost() {
        return redGhost;
    }

    public Ghost getPinkGhost() {
        return pinkGhost;
    }

    public Ghost getCyanGhost() {
        return cyanGhost;
    }

    public Ghost getOrangeGhost() {
        return orangeGhost;
    }

    private Ghost createGhosts() {
        Ghost red = new Ghost(16, 11);
        return red;
    }

    private Ghost createPinkGhost(){
        Ghost pinkGhost = new Ghost(14, 11);
        return pinkGhost;
    }

    private Ghost createCyanGhost(){
        Ghost cyanGhost = new Ghost(12, 11);
        return cyanGhost;
    }

    private Ghost createOrangeGhost(){
        Ghost orangeGhost = new Ghost(10, 11);
        return orangeGhost;
    }




    public boolean canGhostMove(Position position) {
        for(Wall wall: walls) {
            if (position.equals(wall.getPosition())) {
                return false;
            }

        }

        for(VerticalWall verticalWall : verticalWalls) {
            if (position.equals(verticalWall.getPosition())) {
                return false;
            }
        }

        if (check(position)) return false;
        if(position.equals(redGhost.getPosition())) {
            return false;
        }

        if(position.equals(pinkGhost.getPosition())) {
            return false;
        }

        if(position.equals(cyanGhost.getPosition())) {
            return false;
        }

        if(position.equals(orangeGhost.getPosition())) {
            return false;
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
            Position pRight = new Position(ghost.getPosition().getX() + r.nextInt(3) - 1,ghost.getPosition().getY());
            Position pLeft = new Position(ghost.getPosition().getX(), ghost.getPosition().getY() + r.nextInt(3) - 1);
            if(canGhostMove(pRight)) return pRight;
            if(canGhostMove(pLeft)) return pLeft;
            return ghost.getPosition();
        }

    }

    public void moveGhosts(){
        redGhost.setPosition(moveGhost(redGhost));
        pinkGhost.setPosition(moveGhost(pinkGhost));
        orangeGhost.setPosition(moveGhost(orangeGhost));
        cyanGhost.setPosition(moveGhost(cyanGhost));

    }

   public boolean checkGhostEatsPlayer() {
        if(redGhost.getPosition().equals(player.getPosition())) return true;
        else if(orangeGhost.getPosition().equals(player.getPosition())) return true;
        else if(cyanGhost.getPosition().equals(player.getPosition())) return true;
        else if(pinkGhost.getPosition().equals(player.getPosition())) return true;
        return false;
   }

    private void retrievePellets() {
        MusicPlayer musicPlayer = new MusicPlayer("/music/Chomp.wav");
        musicPlayer.startMusic();
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


    public String getScore(){
        return Integer.toString(score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Pellet> getPellets() {
        return pellets;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<VerticalWall> getVerticalWalls() {
        return verticalWalls;
    }

    public ArrayList<CurvedDownRightWall> getCurvedDownRightWalls() {
        return curvedDownRightWalls;
    }

    public ArrayList<CurvedDownLeftWall> getCurvedDownLeftWalls() {
        return curvedDownLeftWalls;
    }

    public ArrayList<CurvedUpperLeftWall> getCurvedUpperLeftWalls() {
        return curvedUpperLeftWalls;
    }

    public ArrayList<CurvedUpperRightWall> getCurvedUpperRightWalls() {
        return curvedUpperRightWalls;
    }
}


