package com.aor.g608.state;

import java.io.IOException;

public abstract class State {

    public void changeState(State state) {}
    public abstract void draw() throws IOException;

}
