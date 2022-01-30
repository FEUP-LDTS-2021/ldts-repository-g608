package com.aor.g608.viewer.menu;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.menu.Arrow;
import com.aor.g608.viewer.Viewer;
import com.aor.g608.viewer.game.ElementViewer;

import java.io.IOException;

public class ArrowViewer implements ElementViewer<Arrow> {

    @Override
    public void draw(Arrow arrow, GUI gui) {
        gui.drawArrow(arrow.getPosition(), "#FF0000");
    }
}
