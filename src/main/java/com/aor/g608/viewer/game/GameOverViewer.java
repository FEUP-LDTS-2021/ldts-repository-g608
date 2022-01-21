package com.aor.g608.viewer.game;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.game.Position;
import com.aor.g608.viewer.Viewer;

import java.io.IOException;

public class GameOverViewer extends Viewer {
    public GameOverViewer(GUI gui) {
        super(gui);
        MusicPlayer musicPlayer = new MusicPlayer("/music/Pacman-death.wav");
        musicPlayer.startMusic();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawText(new Position(8, 10), "GAME OVER", "#000000", "#FF0000");
        gui.drawText(new Position(2, 19), "PRESS ENTER TO GO TO MENU", "#000000", "#FFFFFF");
        gui.drawText(new Position(2, 20), "PRESS ESC TO EXIT", "#000000", "#FFFFFF");
        gui.refresh();
    }
}
