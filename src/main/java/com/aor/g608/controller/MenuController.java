package com.aor.g608.controller;


import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.model.menu.Menu;
import com.aor.g608.state.PlayState;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;




public class MenuController extends Controller<Menu> {

    public MenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Menu menu, GUI.PressedKey action, long time) throws IOException {
        switch(action) {
            case DOWN -> menu.getArrow().setPosition(new Position(menu.getArrow().getPosition().getX(), menu.getArrow().getPosition().getY() + 2));
            case UP -> menu.getArrow().setPosition(new Position(menu.getArrow().getPosition().getX(), menu.getArrow().getPosition().getY() - 2));
        }
    }
}

