package com.aor.g608.model.game;

import com.aor.g608.Element;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Player extends Element implements GUI {

    public Player(Position position, String color) {
        super(position, color);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }


    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.ANSI.YELLOW);
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "C");
    }


}
