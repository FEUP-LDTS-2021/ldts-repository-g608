package com.aor.g608.model.menu;


import com.aor.g608.Game;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MenuPlayer  {
    //protected List<Button> options;
    //private final Game game;
    private int selected;

    private Button button;

    /*
    public void ngButton() {
        JButton btnNewGame = new JButton("New Game");
        button.styleButton(btnNewGame, 76, 456, 231, 65, 24);
    }
    */


    public MenuPlayer() throws IOException {
    }

    public void draw(TextGraphics screen) throws IOException {
        screen.setBackgroundColor(TextColor.ANSI.BLACK);
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(60, 20), ' ');
        screen.putString(20, 3, "PAC-MAN ©2022", SGR.CIRCLED);
        screen.setForegroundColor(TextColor.ANSI.YELLOW);

    }
}