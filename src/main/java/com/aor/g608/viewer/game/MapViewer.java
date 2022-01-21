package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Element;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.ghost.CyanGhostViewer;
import com.aor.g608.viewer.ghost.GhostViewer;
import com.aor.g608.viewer.ghost.OrangeGhostViewer;
import com.aor.g608.viewer.ghost.PinkGhostViewer;
import com.aor.g608.viewer.wall.*;

import java.util.List;

public class MapViewer {
    private final Map map;
    private final GUI gui;


    public MapViewer(GUI gui, Map map) {
        this.gui = gui;
        this.map = map;
    }

    public void draw() {
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#000000");
        drawElements(this.map.getWalls(), new WallViewer());
        drawElements(this.map.getPellets(), new PelletViewer());
        drawElement(this.map.getRedGhost(), new GhostViewer());
        drawElement(this.map.getPinkGhost(), new PinkGhostViewer());
        drawElement(this.map.getCyanGhost(), new CyanGhostViewer());
        drawElement(this.map.getOrangeGhost(), new OrangeGhostViewer());
        drawElement(this.map.getPlayer(), new PlayerViewer());
        drawElements(this.map.getCurvedDownLeftWalls(), new CurvedDownLeftWallViewer());
        drawElements(this.map.getVerticalWalls(), new VerticalWallViewer());
        drawElements(this.map.getCurvedUpperLeftWalls(), new CurvedUpperLeftWallViewer());
        drawElements(this.map.getCurvedDownRightWalls(), new CurvedDownRightWallViewer());
        drawElements(this.map.getCurvedUpperRightWalls(), new CurvedUpperRightWallViewer());
        gui.drawText(new Position(2, 28), "SCORE", "#000000", "#FFFFFF");
        gui.drawText(new Position(8, 28), map.getScore(), "#000000", "#FFFFFF");
    }


    private <T extends Element> void drawElements(List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(element, viewer);
    }

    private <T extends Element> void drawElement(T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
