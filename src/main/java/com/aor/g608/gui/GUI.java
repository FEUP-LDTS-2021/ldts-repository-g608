package com.aor.g608.gui;

import com.aor.g608.model.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public interface GUI {
    enum COLORS {
        PINK,
        ORANGE,
        RED,
        CYAN
    }

    TextGraphics createTextGraphics();

    int getWidth();
    int getHeight();

    void clear() throws IOException;

    void refresh() throws IOException;

    void close() throws IOException;


    void drawBackground(TextGraphics textGraphics, String color);

    void drawRectangle(TextGraphics textGraphics, String color, int width, int height, Position position);

    void drawButton(Position position, String text, String textColor, int width, int height);

    void drawGhosts(Position position, String colors);

    void drawPacman(Position position, String color);

    void drawWall(Position position, String color);

    void drawPellet(Position position, String color);

    void drawTitle(Position position, String text, String color, String colorText);
}
