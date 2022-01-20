package com.aor.g608.state;

import com.aor.g608.state.State;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Map;

public class GameState {
    private State state;
    protected Map map;

    public enum gameMode{
        MENU,
        PLAY,
        RULES,
        EXIT
    }

    public GameState(GUI gui) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
