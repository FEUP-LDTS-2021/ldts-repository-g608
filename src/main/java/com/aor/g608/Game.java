package com.aor.g608;

import com.aor.g608.gui.GUI;
import com.aor.g608.gui.LanternaGUI;
import com.aor.g608.model.game.Map;
import com.aor.g608.state.MenuState;
import com.aor.g608.state.State;
import com.aor.g608.model.menu.Menu;
import com.aor.g608.viewer.game.MusicPlayer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private Map map;
    private Menu menu;
    private int width, height, fps = 20;
    private boolean exit;
    private GUI gui;
    private State state;


    private static Game singleton = null;

    public static void main(String[] args) throws IOException, FontFormatException {
        getInstance().run();
    }


    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Game(int width, int height) throws IOException, FontFormatException {
            this.exit = false;
            this.width = width;
            this.height = height;
            gui = new LanternaGUI(width, height);
            menu = new Menu(gui);
            state = new MenuState(this, gui, menu);
            map = new Map(width, height, gui);


        }

    public void draw() throws IOException{
        gui.clear();
        //final TextGraphics textGraphics = screen.newTextGraphics();
        //this.textGraphics = textGraphics;
        //textGraphics.putString(2, 32, "SCORE: ", SGR.BOLD)
        //textGraphics.putString( 2 + "SCORE: ".length(), 32, map.getScore(), SGR.BOLD);
        //textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        state.start(gui);
        gui.refresh();
    }

    public void menuDraw() throws IOException {
        gui.clear();
        menu.draw();
        gui.refresh();
    }


    public void run() throws IOException {

        int fps = 1000/this.fps;

        try{
                while(!exit){
                    long startTime = System.currentTimeMillis();
                    state.start(gui);
                    KeyStroke userInput = gui.getScreen().pollInput();

                    //processKey(userInput);
                    if(userInput != null){
                        if (userInput.getKeyType() == KeyType.EOF){
                            gui.close(); break;
                        }
                        else state.processInput(userInput);
                    }

                    long elapsedTime = System.currentTimeMillis() - startTime;
                    long sleepTime = fps - elapsedTime;
                    if(sleepTime > 0 ) Thread.sleep(sleepTime);
                     }
                } catch (InterruptedException | IOException | URISyntaxException | FontFormatException e){
                e.printStackTrace();
            }
        }

    public void processKey(KeyStroke key) throws IOException {
            System.out.println(key);
            switch(key.getKeyType()){
                case ArrowUp -> map.movePlayer(map.getPlayer().moveUp());
                case ArrowDown -> map.movePlayer(map.getPlayer().moveDown());
                case ArrowLeft -> map.movePlayer(map.getPlayer().moveLeft());
                case ArrowRight -> map.movePlayer(map.getPlayer().moveRight());
            }
        }

    public static Game getInstance() throws IOException, FontFormatException {
        singleton = new Game(28, 31);
        return singleton;
    }

    public void setState(State state) {
        this.state = state;
    }

    public GUI getGui() {
        return gui;
    }

    public Map getMap() {
        return map;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}