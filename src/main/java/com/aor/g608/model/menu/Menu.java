package com.aor.g608.model.menu;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.menu.MenuViewer;

import java.io.IOException;
public class Menu {
    protected GUI gui;
    protected MenuViewer menuViewer;
    private Arrow arrow;

    public Menu(GUI gui) {
        this.gui = gui;
        arrow = new Arrow(5, 14);
        menuViewer = new MenuViewer(gui);
    }

    public void draw() throws IOException {
        menuViewer.draw(gui);
    }

    public void moveArrow(Position position){
        arrow.setPosition(position);
    }

    public Arrow getArrow() {
        return arrow;
    }
}
