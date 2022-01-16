package com.aor.g608.state;

import com.aor.g608.Game;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.Position;
import com.aor.g608.model.menu.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayState extends State{


    public PlayState(Game game, GUI gui) throws IOException {
        super(game, Arrays.asList(new Button(new Position(3, 9),"Needs to be implemented", Arrays.asList("#FFFFFF", "#FF0000")), new Button(new Position(4, 10),"Needs to be implemented as well", Arrays.asList("#FFFFFF", "#FF0000"))));
    }

    @Override
    public void start() {

    }

}
