package com.aor.g608.viewer.wall;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.wall.CurvedDownLeftWall;
import com.aor.g608.viewer.game.ElementViewer;

public class CurvedDownLeftWallViewer implements ElementViewer<CurvedDownLeftWall> {
    @Override
    public void draw(CurvedDownLeftWall element, GUI gui) {
        gui.drawCurvedDownLeftWall(element.getPosition(), "#3232CD");
    }
}
