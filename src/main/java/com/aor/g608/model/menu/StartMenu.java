package com.aor.g608.model.menu;

import com.aor.g608.Game;
import com.aor.g608.model.Position;

import java.io.IOException;
import java.util.Arrays;

public class StartMenu extends Menu{

    public StartMenu(Game game) throws IOException {
        super(game);

        Position playPosition = new Position(11, 10);
        Position instructionsPosition = new Position(7, 13);
        Position exitPosition = new Position(11, 16);

        options.add(new Button(playPosition, "play", Arrays.asList("#FFFFFF")));
        options.add(new Button(instructionsPosition, "instructions", Arrays.asList("#FFFFFF")));
        options.add(new Button(exitPosition, "exit", Arrays.asList("#FFFFFF")));
    }
}
