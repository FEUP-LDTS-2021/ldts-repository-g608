package com.aor.g608.gui;

import com.aor.g608.model.game.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {

    enum PressedKey {UP,DOWN,RIGHT,LEFT,OTHER,ESCAPE, ENTER};

    TextGraphics createTextGraphics();

    void refresh() throws IOException;

    void clear();

    void close() throws IOException;

    Screen getScreen();

    void drawBackground(TextGraphics textGraphics, String color);

    void drawGhosts(Position position, String color);

    void drawPacman(Position position, String color);

    void drawWall(Position position, String color);

    void drawPellet(Position position, String color);

    void drawText(Position position, String text, String textColor, String backgroundColor);

    void drawPowerUp(Position position, String color);

    void drawArrow(Position position, String arrowColor);

}
