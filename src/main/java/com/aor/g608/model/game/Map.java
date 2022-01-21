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

    private GhostDatabase database;
    private ArrayList<Wall> walls;
    private Ghost redGhost;
    private Ghost pinkGhost;
    private Ghost cyanGhost;
    private Ghost orangeGhost;
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
                switch (ch[col]) {
                    case 'a' -> curvedDownLeftWalls.add(new CurvedDownLeftWall(col, row));
                    case 'b' -> curvedDownRightWalls.add(new CurvedDownRightWall(col, row));
                    case 'c' -> curvedUpperLeftWalls.add(new CurvedUpperLeftWall(col, row));
                    case 'd' -> curvedUpperRightWalls.add(new CurvedUpperRightWall(col, row));
                    case 'e' -> walls.add(new Wall(col, row));
                    case 'f' -> verticalWalls.add(new VerticalWall(col, row));
                    case '.' -> pellets.add(new Pellet(col, row));
                    case '-' -> powerUps.add(new PowerUp(col, row));
                }
            }
        }
        this.walls = walls;
        this.pellets = pellets;
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

        return !check(position);


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
        return new Ghost(16, 11);
    }

    private Ghost createPinkGhost(){
        return new Ghost(14, 11);
    }

    private Ghost createCyanGhost(){
        return new Ghost(12, 11);
    }

    private Ghost createOrangeGhost(){
        return new Ghost(10, 11);
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

        return !position.equals(orangeGhost.getPosition());
    }

    public Position moveGhost(Ghost ghost) {
        Random r = new Random();

        Position pRight = new Position(ghost.getPosition().getX() + r.nextInt(3) - 1,ghost.getPosition().getY());
        Position pLeft = new Position(ghost.getPosition().getX(), ghost.getPosition().getY() + r.nextInt(3) - 1);
        if(canGhostMove(pRight)) return pRight;
        if(canGhostMove(pLeft)) return pLeft;
        return ghost.getPosition();


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
        else return pinkGhost.getPosition().equals(player.getPosition());
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


