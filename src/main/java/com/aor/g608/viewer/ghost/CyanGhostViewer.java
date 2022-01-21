package com.aor.g608.viewer.ghost;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.viewer.game.ElementViewer;

public class CyanGhostViewer implements ElementViewer<Ghost> {

    public void draw(Ghost cyanGhost, GUI gui){gui.drawGhosts(cyanGhost.getPosition(), "#00FFFF");}
}
