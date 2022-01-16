package com.aor.g608.command;

import com.aor.g608.state.State;

public class ButtonCommand implements Command{
    private State state;

    public ButtonCommand(State state) {this.state = state;}

    @Override
    public boolean execute() {
        return true;
    }

    @Override
    public void undo() {

    }

    public State getState() {return state; }
}
