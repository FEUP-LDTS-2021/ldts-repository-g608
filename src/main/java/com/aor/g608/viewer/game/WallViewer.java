package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Wall;

public class WallViewer implements ElementViewer<Wall>{

    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition(), "#FFFFFF");
    }
}
