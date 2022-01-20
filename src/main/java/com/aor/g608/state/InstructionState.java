package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.viewer.game.InstructionsViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class InstructionState implements State{

    private final Game game;
    InstructionsViewer instructionsViewer;
    GUI gui;

    public InstructionState(Game game) {
        gui = game.getGui();
        instructionsViewer = new InstructionsViewer(gui);
        this.game = game;
    }

    @Override
    public void start(GUI gui) throws IOException {
        instructionsViewer.draw(gui);
    }


    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {

    }
}
