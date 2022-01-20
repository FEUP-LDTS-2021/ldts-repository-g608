package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Element;
import com.aor.g608.model.game.Map;
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
        drawElements(this.map.getGhosts(), new GhostViewer());
        drawElement(this.map.getPlayer(), new PlayerViewer());
        //drawElements(this.map.getPlayer(), new PlayerVi);
    }


    private <T extends Element> void drawElements(List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(element, viewer);
    }

    private <T extends Element> void drawElement(T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
