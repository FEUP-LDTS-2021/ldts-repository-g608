package com.aor.g608;

import com.aor.g608.gui.GUI;
import com.aor.g608.gui.KeyBoardObserver;
import com.aor.g608.gui.LanternaGUI;
import com.aor.g608.model.Position;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.menu.MenuPlayer;
import com.aor.g608.state.MenuState;
import com.aor.g608.state.State;
import com.aor.g608.viewer.game.MusicPlayer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.TerminalSize;


import java.awt.*;
import java.io.IOException;


public class Game {
    private Map map;
    private Player player;
    private LanternaGUI lanternaGUI;
    private MenuPlayer menuPlayer;
    private int width, height, fps;
    private boolean exit ;
    private GUI gui;
    private State state;
    private KeyBoardObserver keyBoardObserver;

    public static void main(String[] args) throws IOException, FontFormatException {
        Game game = new Game(28, 31, 30);
        game.run();
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
            this.state = new MenuState(this, gui);
            this.lanternaGUI = new LanternaGUI(width, height);
            this.exit = false;

            //TerminalSize terminalSize = new TerminalSize(width, height);
            //DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            //Terminal terminal = terminalFactory.createTerminal();
            //screen = new TerminalScreen(terminal);
            //screen.setCursorPosition(null);
            //screen.startScreen();
            //screen.doResizeIfNecessary();
            //menuPlayer = new MenuPlayer();
            //map = new Map(width, height);
        }

    private void draw() throws IOException, FontFormatException {
        lanternaGUI.clear();
        lanternaGUI.createTextGraphics();

        Position playPosition = new Position(11, 10);
        Position instructionsPosition = new Position(7, 13);
        Position leaderboardPosition = new Position(7, 16);
        Position exitPosition = new Position(11, 19);


        lanternaGUI.drawTitle(playPosition,"play", "#000000", "#FFFF00");
        lanternaGUI.drawTitle(instructionsPosition,"instructions", "#000000", "#FFFF00");
        lanternaGUI.drawTitle(leaderboardPosition,"leaderboard", "#000000", "#FFFF00");
        lanternaGUI.drawTitle(exitPosition,"exit", "#000000", "#FFFF00");
        //menuPlayer.draw(screen.newTextGraphics());
        //map.draw(screen.newTextGraphics());
        lanternaGUI.refresh();
    }

    public void run() throws IOException {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.startMusic();

        try{
                while(!exit){
                    draw();
                    KeyStroke userInput = lanternaGUI.getScreen().readInput();

                    processKey(userInput);

                    if (userInput.getKeyType() == KeyType.EOF)
                        break;


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
    }