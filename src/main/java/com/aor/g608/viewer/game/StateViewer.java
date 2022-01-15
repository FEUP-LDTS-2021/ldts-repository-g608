package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.menu.Button;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.List;

public abstract class StateViewer {
    protected GUI gui;
    private TextGraphics textGraphics;
    protected List<Button> buttons;

    public StateViewer(GUI gui, List<Button> buttons) {
        this.gui = gui;
        this.buttons = buttons;
    }


    public abstract void draw() throws IOException;

    protected void drawBackground(String color){
        gui.drawBackground(this.textGraphics, color);
    }

    protected void drawButtons(List<Button> buttons, ElementViewer<Button> viewer){
        for (int i = buttons.size()-1; i >= 0; i--) {
            viewer.drawElement(buttons.get(i), gui);
        }
    }
}
