package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.viewer.game.GameOverViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverState implements State{

    private int selected;
    private Game game;

    GameOverViewer gameOverViewer;
    GUI gui;

    public GameOverState(Game game) {
        this.game = game;
        gui = game.getGui();
        gameOverViewer = new GameOverViewer(gui);
    }

    @Override
    public void start(GUI gui) throws IOException {
        gameOverViewer.draw(gui);
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {

    }
}
