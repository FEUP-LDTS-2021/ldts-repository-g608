package com.aor.g608.state;

import com.aor.g608.gui.GUI;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.security.spec.KeySpec;

public interface State {
    void start(GUI gui) throws IOException;
}
