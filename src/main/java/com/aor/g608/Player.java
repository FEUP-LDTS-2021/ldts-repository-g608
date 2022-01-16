package com.aor.g608;

import com.aor.g608.gui.GUI;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element implements GUI {
    private Position position;

    public Player(Position position, String color) {
        super(position, color);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    @Override
    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.ANSI.YELLOW);
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "C");
    }
}
