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
    private Map map;


    public Game() throws IOException {
            TerminalSize terminalSize = new TerminalSize(40, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            map = new Map(40, 40);
        }

        private void draw () throws IOException {
            screen.clear();
            map.draw(screen.newTextGraphics());
            screen.refresh();
        }

        public void run () throws IOException {
            draw();
        }
    }