package com.aor.g608.viewer;

import com.aor.g608.gui.GUI;

import java.io.IOException;

public abstract class Viewer {
    private final GUI gui;

    public Viewer(GUI gui) {
        this.gui = gui;
    }

    public void draw(GUI gui) throws IOException{};

    // protected void drawElements(GUI gui) throws IOException;
}
