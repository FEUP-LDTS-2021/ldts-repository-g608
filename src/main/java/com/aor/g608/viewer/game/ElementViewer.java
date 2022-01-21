package com.aor.g608.viewer.game;

import com.aor.g608.model.game.Element;
import com.aor.g608.gui.GUI;

public interface ElementViewer <T extends Element>{
    void draw(T element, GUI gui);
}