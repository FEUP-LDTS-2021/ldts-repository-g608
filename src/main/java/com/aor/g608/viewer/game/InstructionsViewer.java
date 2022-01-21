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
        gui.clear();
        gui.drawBackground(gui.createTextGraphics(), "#000000");
        gui.drawText(new Position(10, 4), "RULES", "#000000", "#00FFFF");
        gui.drawText(new Position(2, 7), "TO WIN YOU MUST COLLECT",  "#000000", "#00FFFF");
        gui.drawText(new Position(2, 8), "ALL THE PELLETS AVOIDING", "#000000", "#00FFFF");
        gui.drawText(new Position(2, 9), "THE GHOSTS THAT WILL TRY", "#000000", "#00FFFF");
        gui.drawText(new Position(2, 10), "TO EAT YOU IN THE MAP.", "#000000", "#00FFFF");
        gui.drawText(new Position(2, 12), "USE ARROWS TO MOVE", "#000000", "#00FFFF");
        gui.drawText(new Position(1, 20), "PRESS ESC TO RETURN","#000000", "#00FFFF" );
        gui.refresh();

    }
}
