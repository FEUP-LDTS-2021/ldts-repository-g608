package com.aor.g608.viewer.game;


import com.aor.g608.gui.GUI;
import com.aor.g608.model.menu.Button;
import com.aor.g608.state.State;

import java.io.IOException;
import java.util.List;

public class MenuViewer extends StateViewer{

    public MenuViewer(GUI gui, List<Button> buttons) {
        super(gui, buttons);
    }
    @Override
    public void draw() throws IOException {
        //gui.clear();
        //drawBackground("#000000");
        drawButtons(buttons, new ButtonViewer());
        //gui.refresh();
    }
}
