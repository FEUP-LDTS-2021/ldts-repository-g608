package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.menu.Menu;
import com.aor.g608.viewer.game.MapViewer;
import com.aor.g608.viewer.game.MusicPlayer;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PlayState implements State{
    private Game game;
    private GUI gui;
    private Map map;
    private Menu menu;
    private State state;
    private MapViewer mapViewer;

    public PlayState(Game game) throws IOException {
        this.gui = game.getGui();
        mapViewer = new MapViewer(gui, map);
        this.game = game;
        this.map = game.getMap();
        this.menu = game.getMenu();
        MusicPlayer musicPlayer = new MusicPlayer("/music/Intro.wav");
        musicPlayer.startMusic();
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
        map.draw();
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException{
        if(keystroke.getKeyType() == KeyType.Escape)
            game.setState(new PauseState(game));

        game.processKey(keystroke);
    }


}
