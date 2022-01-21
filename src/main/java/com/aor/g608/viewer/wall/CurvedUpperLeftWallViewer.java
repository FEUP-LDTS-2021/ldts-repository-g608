package com.aor.g608.viewer.wall;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.wall.CurvedDownLeftWall;
import com.aor.g608.model.wall.CurvedUpperLeftWall;
import com.aor.g608.viewer.game.ElementViewer;

public class CurvedUpperLeftWallViewer implements ElementViewer<CurvedUpperLeftWall> {

    @Override
    public void draw(CurvedUpperLeftWall element, GUI gui) {
        gui.drawCurvedUpperLeftWall(element.getPosition(), "#3232CD");
    }
}
