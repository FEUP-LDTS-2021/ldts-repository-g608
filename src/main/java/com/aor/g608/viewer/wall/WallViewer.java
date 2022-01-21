package com.aor.g608.viewer.wall;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.wall.Wall;
import com.aor.g608.viewer.game.ElementViewer;

public class WallViewer implements ElementViewer<Wall> {

    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition(), "#3232CD");
    }
}
