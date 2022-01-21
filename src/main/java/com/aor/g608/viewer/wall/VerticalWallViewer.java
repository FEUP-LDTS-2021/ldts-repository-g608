package com.aor.g608.viewer.wall;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.wall.VerticalWall;
import com.aor.g608.viewer.game.ElementViewer;

public class VerticalWallViewer implements ElementViewer<VerticalWall> {
    @Override
    public void draw(VerticalWall element, GUI gui) {
        gui.drawVerticalWall(element.getPosition(), "#3232CD");
    }
}
