package com.aor.g608.controller;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface Controller {
    void processInput(KeyStroke keyStroke) throws IOException;
}
