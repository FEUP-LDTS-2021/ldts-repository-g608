package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Map;
import com.aor.g608.viewer.game.GameWonViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameWonState implements State{
    private final Game game;

    GameWonViewer gameWonViewer;
    GUI gui;


    public GameWonState(Game game) {
        gui = game.getGui();
        this.game = game;
        gameWonViewer = new GameWonViewer(gui);
    }

    @Override
    public void start(GUI gui) throws IOException {
        gameWonViewer.draw(gui);
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException {
        switch(keystroke.getKeyType()){
            case Enter -> {
                game.setMap(new Map(game.getWidth(), game.getHeight(), gui));
                game.setState(new MenuState(game, gui, game.getMenu()));
            }
        }
    }
}
