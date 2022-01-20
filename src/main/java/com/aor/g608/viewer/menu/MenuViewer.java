package com.aor.g608.viewer.menu;


import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.model.menu.Menu;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class MenuViewer extends Viewer {

    public MenuViewer(GUI gui) {
        super(gui);
    }

    public void draw(GUI gui, Menu menu) throws IOException {
        gui.drawBackground(gui.createTextGraphics(),"#000000");
        gui.drawText(new Position(10,6),"PA*MAN","#000000","#FFFF00");
        gui.drawText(new Position(11,14),"PLAY","#FFFFFF","#000000");
        gui.drawText(new Position(7,16),"INSTRUCTIONS","#FFFFFF","#000000");
        gui.drawText(new Position(11,18),"EXIT","#FFFFFF","#000000");
        drawArrow(gui, menu);
        gui.refresh();
    }

    public void drawArrow(GUI gui, Menu menu){
        gui.drawArrow(menu.getArrow().getPosition(), "#FFFFFF");
    }
}
