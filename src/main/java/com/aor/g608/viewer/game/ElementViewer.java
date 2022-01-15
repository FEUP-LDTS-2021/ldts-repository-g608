package com.aor.g608.viewer.game;

import com.aor.g608.Element;
import com.aor.g608.gui.GUI;

public interface ElementViewer<T extends Element>{
    void drawElement(T element, GUI gui);
}
