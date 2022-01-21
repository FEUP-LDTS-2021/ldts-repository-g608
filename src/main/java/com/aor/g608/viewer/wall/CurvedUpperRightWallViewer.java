package com.aor.g608.viewer.wall;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.wall.CurvedUpperRightWall;
import com.aor.g608.viewer.game.ElementViewer;

public class CurvedUpperRightWallViewer implements ElementViewer<CurvedUpperRightWall> {

    @Override
    public void draw(CurvedUpperRightWall element, GUI gui) {
        gui.drawCurvedUpperRightWall(element.getPosition(), "#3232CD");
    }
}
