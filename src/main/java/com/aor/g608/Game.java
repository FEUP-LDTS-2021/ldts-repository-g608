package com.aor.g608;

import com.aor.g608.gui.LanternaGUI;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.menu.MenuPlayer;
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
    private Screen screen;
    private Map map;
    private Player player;
    private LanternaGUI lanternaGUI;
    private MenuPlayer menuPlayer;
    private int width, height, fps;

    public static void main(String[] args) throws IOException, FontFormatException {
        LanternaGUI lanternaGUI = new LanternaGUI();
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

    public Game(int width, int height, int fps) throws IOException {
            this.width = width;
            this.height = height;
            this.fps = fps;
            TerminalSize terminalSize = new TerminalSize(width, height);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            menuPlayer = new MenuPlayer();
            map = new Map(width, height);
        }

        private void draw() throws IOException {
            screen.clear();
            //menuPlayer.draw(screen.newTextGraphics());
            map.draw(screen.newTextGraphics());
            screen.refresh();
        }

        public void run() throws IOException {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.startMusic();
        try{
                while(true){
                    draw();
                    KeyStroke userInput = screen.readInput();

                    processKey(userInput);

                    if (userInput.getKeyType() == KeyType.EOF)
                        break;


                }
            } catch (IOException e){
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