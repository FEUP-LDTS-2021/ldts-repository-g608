package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.controller.MenuController;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.model.menu.Menu;
import com.aor.g608.viewer.menu.MenuViewer;
import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuState  implements State {
    private final GUI gui;
    private final Game game;
    private MenuViewer menuViewer;
    private final Menu menu;


    public MenuState(Game game, GUI gui, Menu menu) {
        this.gui = gui;
        this.menu = menu;
        this.game = game;
        menuViewer = new MenuViewer(gui);
    }

    @Override
    public void start(GUI gui) throws IOException {
        menuViewer.draw(gui, menu);
    }

    @Override
    public void processInput(KeyStroke keystroke) throws IOException, URISyntaxException, FontFormatException {
        System.out.println(keystroke);

        switch (keystroke.getKeyType()) {
            case ArrowDown -> {
                if (menu.getArrow().getPosition().getY() + 2 <= 18)
                    menu.getArrow().setPosition(new Position(menu.getArrow().getPosition().getX(), menu.getArrow().getPosition().getY() + 2));
            }

            case ArrowUp -> {
                if (menu.getArrow().getPosition().getY() - 2 >= 14)
                    menu.getArrow().setPosition(new Position(menu.getArrow().getPosition().getX(), menu.getArrow().getPosition().getY() - 2));

            }

            case Enter -> {
                if(menu.getArrow().getPosition().getY() == 14)
                    game.setState(new PlayState(game));
                if(menu.getArrow().getPosition().getY() == 16)
                    game.setState(new InstructionState(game));
                if(menu.getArrow().getPosition().getY() == 18)
                    gui.close();
            }
        }
    }
}
