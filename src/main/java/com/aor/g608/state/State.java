package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.spec.KeySpec;

public interface State {
    void start(GUI gui) throws IOException;
    void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException;
}
