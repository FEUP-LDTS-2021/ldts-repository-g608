package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Ghost;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Wall;
import com.aor.g608.model.item.Pellet;
import com.aor.g608.viewer.Viewer;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class MapViewer extends Viewer {
    TextGraphics textGraphics;
    Screen screen;
    GhostViewer ghostViewer;
    PelletViewer pelletViewer;
    WallViewer wallViewer;
    Map map;


    public MapViewer(GUI gui, Map map) {
        super(gui);
        this.map = map;
    }


    @Override
    public void draw(GUI gui) {
        gui.drawBackground(gui.createTextGraphics(), "#000000");
    }

    protected void drawElements(GUI gui) throws IOException {
        for(Ghost e : map.getGhosts()){
            ghostViewer.draw(e, gui);
        }

        for(Wall w : map.getWalls()){
            wallViewer.draw(w, gui);
        }

        for(Pellet p : map.getPellets()){
            pelletViewer.draw(p, gui);
        }


    }
}
