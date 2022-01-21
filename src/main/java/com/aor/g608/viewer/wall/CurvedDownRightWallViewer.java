package com.aor.g608.viewer.wall;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.wall.CurvedDownLeftWall;
import com.aor.g608.model.wall.CurvedDownRightWall;
import com.aor.g608.viewer.game.ElementViewer;

public class CurvedDownRightWallViewer implements ElementViewer<CurvedDownRightWall> {

    @Override
    public void draw(CurvedDownRightWall element, GUI gui) {
        gui.drawCurvedDownRightWall(element.getPosition(), "#3232CD");
    }
}
