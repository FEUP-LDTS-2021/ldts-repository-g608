package com.aor.g608.controller;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    public final T model;

    public Controller(T model) {this.model = model;}

    public T getModel() {return model;}

    public abstract void step(T t, GUI.PressedKey action, long time) throws IOException;
}
