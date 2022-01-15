package com.aor.g608.model.game;

import com.aor.g608.model.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.aor.g608.Element;

public class Pellet extends Element{

    public Pellet(Position position, String color) {
        super(position, color);
    }

        @Override
        public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#999933"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "$");
    }
/*
        @Override
        public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()) return false;

        return(this == o || this.getPosition().equals(Pellet.getPosition()));

    }

 */
}


