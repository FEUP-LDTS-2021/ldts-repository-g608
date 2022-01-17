package com.aor.g608.model.game;

import com.aor.g608.Element;
import com.aor.g608.gui.GUI;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Ghost extends Element implements GUI {

    public Ghost(Position position, String color) {
        super(position, color);
    }

    public String getColor() {
        return color;
    }

    @Override
    public void draw(TextGraphics screen) {
        if(getColor() == "red"){
            screen.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
            screen.enableModifiers(SGR.BOLD);
            screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "R");
        }
        if(getColor() == "cyan"){
            screen.setForegroundColor(TextColor.Factory.fromString("#00FFFF"));
            screen.enableModifiers(SGR.BOLD);
            screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "C");
        }
        if(getColor() == "orange"){
            screen.setForegroundColor(TextColor.Factory.fromString("#FFA500"));
            screen.enableModifiers(SGR.BOLD);
            screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "O");
        }
        if(getColor() == "pink"){
            screen.setForegroundColor(TextColor.Factory.fromString("#FFC0CB"));
            screen.enableModifiers(SGR.BOLD);
            screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "P");
        }
    }
}
