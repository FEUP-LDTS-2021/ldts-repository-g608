package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.command.ButtonCommand;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.Position;
import com.aor.g608.model.menu.Button;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MenuState extends State {

    public MenuState(Game game, GUI gui) throws IOException {
        super(game, Arrays.asList(new Button(new Position(game.getWidth() - 7, game.getHeight() -7), "PLAY", new ButtonCommand(new PlayState(game, gui)), "#000000")));
    }

    @Override
    public void start() {

    }


}
