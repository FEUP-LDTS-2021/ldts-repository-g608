package com.aor.g608.viewer.ghost;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.viewer.game.ElementViewer;

public class PinkGhostViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost element, GUI gui) {
        gui.drawGhosts(element.getPosition(), "#FFC0CB");
    }
}
