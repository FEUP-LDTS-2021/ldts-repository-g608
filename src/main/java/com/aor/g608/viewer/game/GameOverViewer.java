package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class GameOverViewer extends Viewer {
    public GameOverViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.drawText(new Position(10, 10), "GAME OVER", "#FFFFFF", "#000000");
    }
}
