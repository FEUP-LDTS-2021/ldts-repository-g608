package com.aor.g608.viewer.menu;


import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer {

    public MenuViewer(GUI gui) {
        super(gui);
    }

    public void draw(GUI gui) throws IOException {
        gui.drawBackground(gui.createTextGraphics(),"#000000");
        gui.drawText(new Position(10,10),"PACMAN","#FFFFFF","#000000");
        gui.drawText(new Position(10,14),"PLAY","#FFFFFF","#000000");
        gui.drawText(new Position(10,16),"INSTRUCTIONS","#FFFFFF","#000000");
        gui.drawText(new Position(10,20),"EXIT","#FFFFFF","#000000");
        gui.refresh();
    }

    public void drawArrow(GUI gui){
        gui.drawText(new Position(6, 14), "-->", "#FFFFFF", "#00000");
    }
}
