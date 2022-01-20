package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.viewer.menu.MenuViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class MenuState  implements State{
    private GUI gui;
    private Game game;
    private MenuViewer menuViewer;


    public MenuState(Game game, GUI gui) {
        this.gui = gui;
        menuViewer = new MenuViewer(gui);
        this.game = game;
    }

    @Override
    public void start(GUI gui) throws IOException {
        menuViewer.draw(gui);
    }
}
