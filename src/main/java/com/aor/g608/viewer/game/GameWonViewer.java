package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class GameWonViewer extends Viewer {

    public GameWonViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawText(new Position(10, 10), "YOU WON", "#FFFFFF", "#000000");
        gui.drawText(new Position(2, 20), "PRESS ENTER TO GO BACK TO MENU", "#FFFFFF", "#000000");
        gui.refresh();
    }
}
