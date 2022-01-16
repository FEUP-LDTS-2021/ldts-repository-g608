package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.model.menu.Button;

import java.io.IOException;
import java.util.List;

public abstract class State {
    protected Game game;
    private List<Button> buttons;

    public State(Game game, List<Button> buttons) {
        this.game = game;
        this.buttons = buttons;
    }

    public abstract void start();

    public List<Button> getButtons() {
        return buttons;
    }

    public void changeState(State state) {}

}
