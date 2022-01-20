package com.aor.g608.model.menu;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.viewer.menu.MenuViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected GUI gui;
    protected MenuViewer menuViewer;

    public Menu(GUI gui) {
        this.gui = gui;
        menuViewer = new MenuViewer(gui);
    }

    public void draw() throws IOException {
        menuViewer.draw(gui);
    }
}
