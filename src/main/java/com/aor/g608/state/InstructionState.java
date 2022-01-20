package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.viewer.game.InstructionsViewer;
import com.googlecode.lanterna.input.KeyStroke;
import com.aor.g608.model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionState implements State{

    private final Game game;
    private InstructionsViewer instructionsViewer;
    private GUI gui;
    private Menu menu;

    public InstructionState(Game game, Menu menu) {
        gui = game.getGui();
        instructionsViewer = new InstructionsViewer(gui);
        this.game = game;
        this.menu = menu;
    }

    @Override
    public void start(GUI gui) throws IOException {
        instructionsViewer.draw(gui);
    }


    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {
        switch (keystroke.getKeyType()) {
            case Escape -> game.setState(new MenuState(game, gui, menu));
        }
    }
}
