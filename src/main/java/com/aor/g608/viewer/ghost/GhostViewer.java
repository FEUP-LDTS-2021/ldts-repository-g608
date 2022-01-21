package com.aor.g608.viewer.ghost;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.viewer.game.ElementViewer;

public class GhostViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost ghost, GUI gui) {
            gui.drawGhosts(ghost.getPosition(), "#FF0000");
    }

}
