package com.aor.g608.model.game;

import com.aor.g608.Element;
import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    public Wall(Position position, String color){
        super(position, color);
    }

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.ANSI.WHITE);
        screen.enableModifiers(SGR.CIRCLED);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "*");
    }

    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;
        return(this == o || this.getPosition().equals(((Wall) o).getPosition()));
    }


}
