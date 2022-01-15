package com.aor.g608.viewer.game;

import com.aor.g608.Element;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.menu.Button;

public class ButtonViewer implements ElementViewer<Button> {
    @Override
    public void drawElement(Button button, GUI gui) {
        gui.drawButton(button.getPosition(), button.getText(), button.getColor(), button.getWidth(), button.getHeight());
    }
}
