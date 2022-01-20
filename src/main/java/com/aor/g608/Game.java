package com.aor.g608;

import com.aor.g608.gui.GUI;
import com.aor.g608.gui.LanternaGUI;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.menu.MenuPlayer;
import com.aor.g608.state.MenuState;
import com.aor.g608.state.State;
import com.aor.g608.viewer.game.MusicPlayer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.awt.*;
import java.io.IOException;

public class Game {
    private Map map;
    private LanternaGUI lanternaGUI;
    private MenuPlayer menuPlayer;
    private int width, height, fps;
    private boolean exit;
    private Screen screen;
    private GUI gui;
    private TextGraphics textGraphics;
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

    public Game(int width, int height, int fps) throws IOException, FontFormatException {
            this.width = width;
            this.height = height;
            this.fps = fps;
            this.exit = false;

            state = new MenuState(this, gui);
            map = new Map(width, height);

        }

    private void draw() throws IOException, FontFormatException {
        screen.clear();
        map.draw(screen.newTextGraphics());
        final TextGraphics textGraphics = screen.newTextGraphics();
        this.textGraphics = textGraphics;
        textGraphics.putString(2, 32, "SCORE: ", SGR.BOLD);
        textGraphics.putString( 2 + "SCORE: ".length(), 32, map.getScore(), SGR.BOLD);
        textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        screen.refresh();
    }

    public void run() throws IOException {
        //testing timer
        long startTime = System.nanoTime();
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.startMusic();

        try{
                while(!exit){
                    draw();
                    KeyStroke userInput = screen.readInput();

                    processKey(userInput);

                    if (userInput.getKeyType() == KeyType.EOF)
                        break;

                    map.moveGhosts();

                    if(map.checkGhostEatsPlayer()) {
                        long endTime = System.nanoTime();
                        getInstance().run();
                        break;
                    }
                }
            } catch (IOException | FontFormatException e){
                e.printStackTrace();
            }
        }

        private void processKey(KeyStroke key) throws IOException{
            System.out.println(key);
            switch(key.getKeyType()){
                case ArrowUp -> map.movePlayer(map.moveUp());
                case ArrowDown -> map.movePlayer(map.moveDown());
                case ArrowLeft -> map.movePlayer(map.moveLeft());
                case ArrowRight -> map.movePlayer(map.moveRight());
            }
        }

    public static Game getInstance() throws IOException, FontFormatException {
        singleton = new Game(40, 42, 30);
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
}