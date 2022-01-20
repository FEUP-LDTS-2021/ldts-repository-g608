package com.aor.g608.controller;


import com.aor.g608.Game;
import com.aor.g608.state.PlayState;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class MenuController implements Controller{
    private final Game game;

    public MenuController(Game game) {
        this.game = game;
    }

    @Override
    public void processInput(KeyStroke key) throws IOException {
        System.out.println(key);
        switch(key.getKeyType()){
            case Enter -> game.setState(new PlayState(game));
        }
    }
}
