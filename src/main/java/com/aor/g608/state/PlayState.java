package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Map;
import com.aor.g608.viewer.game.MapViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PlayState implements State{
    private Game game;
    private GUI gui;
    private Map map;
    private State state;
    private MapViewer mapViewer;

    public PlayState(Game game) throws IOException {
        this.gui = game.getGui();
        mapViewer = new MapViewer(gui, map);
        this.game = game;
    }

    @Override
    public void start(GUI gui) throws IOException {
        game.getMap().moveGhosts();

        if(game.getMap().getPellets().size() == 0){
            game.setState(new GameWonState(game));
        }

        if(game.getMap().checkGhostEatsPlayer()){
            game.setState(new GameOverState(game));
        }

    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {

    }
}
