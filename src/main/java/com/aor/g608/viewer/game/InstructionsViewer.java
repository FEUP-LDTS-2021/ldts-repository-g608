package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class InstructionsViewer extends Viewer {
    public InstructionsViewer(GUI gui) {
        super(gui);
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.drawBackground(gui.createTextGraphics(), "#F0F8FF");
        gui.drawText(new Position(2, 0), "RULES", "#FFFFFF", "#000000");


    }
}
