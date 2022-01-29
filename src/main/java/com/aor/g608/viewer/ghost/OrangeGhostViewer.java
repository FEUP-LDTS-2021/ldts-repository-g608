package com.aor.g608.viewer.ghost;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.viewer.game.ElementViewer;

public class OrangeGhostViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost orangeGhost, GUI gui){gui.drawGhosts(orangeGhost.getPosition(), "#FFA500");}
}
