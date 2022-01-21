package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class PauseViewer extends Viewer {
    public PauseViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawText(new Position(9, 10), "PAUSED", "#000000", "#FFFFFF");
        gui.drawText(new Position(2, 21), "PRESS ANY KEY TO MENU", "#000000", "#FFFFFF");
        gui.drawText(new Position(2, 22), "OR", "#000000", "#FFFFFF");
        gui.drawText(new Position(2,23), "PRESS ESC TO RETURN", "#000000", "#FFFFFF");
        gui.refresh();
    }
}
