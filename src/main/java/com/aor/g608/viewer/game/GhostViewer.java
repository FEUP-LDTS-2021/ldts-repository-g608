package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.ghost.CyanGhost;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.model.ghost.OrangeGhost;
import com.aor.g608.model.ghost.PinkGhost;

public class GhostViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost ghost, GUI gui) {
            gui.drawGhosts(ghost.getPosition(), "#FF0000");
    }

    public void draw(PinkGhost pinkGhost, GUI gui){gui.drawPinkGhost(pinkGhost.getPosition(), "#FFC0CB");}

    public void draw(CyanGhost cyanGhost, GUI gui){gui.drawCyanGhost(cyanGhost.getPosition(), "#00FFFF");}

    public void draw(OrangeGhost orangeGhost, GUI gui){gui.drawCyanGhost(orangeGhost.getPosition(), "#FFA500");}
}
