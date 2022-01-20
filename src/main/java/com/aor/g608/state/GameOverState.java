package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.viewer.game.GameOverViewer;

import java.io.IOException;

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
}
