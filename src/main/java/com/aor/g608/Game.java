package com.aor.g608;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;


import java.io.IOException;


public class Game {
    private Screen screen;
    private int x = 10, y = 10;

    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            screen.clear();
            screen.setCharacter(x, y, TextCharacter.fromCharacter('O')[0]);
            screen.refresh();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void run() throws IOException {
        try {
            while(true) {
                draw();
                KeyStroke key = screen.readInput();
                processKey(key);

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF)
                    break;

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void draw() throws IOException{

    }

    private void processKey(KeyStroke key){
        System.out.println(key);
    }

}
