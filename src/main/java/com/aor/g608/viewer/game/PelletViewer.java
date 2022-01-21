package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.item.Pellet;

public class PelletViewer implements ElementViewer<Pellet>{

    @Override
    public void draw(Pellet pellet, GUI gui) {
        gui.drawPellet(pellet.getPosition(), "#FFFF00");
    }
}
