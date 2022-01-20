package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Wall;
import com.aor.g608.viewer.Viewer;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MapViewer extends Viewer {
    TextGraphics textGraphics;
    Screen screen;

    public MapViewer(GUI gui) {
        super(gui);
    }


    @Override
    public void draw(GUI gui) {
        gui.drawBackground(gui.createTextGraphics(), "#000000");
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        for(auto e : )
    }
}
