package com.aor.g608.model.game;

import com.aor.g608.Element;
import com.aor.g608.model.Position;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.util.List;
import java.util.Random;

public class Ghost extends Element{
    private int x, y;
    private String color;
    enum colors {RED, CYAN, ORANGE, PINK}

    public Ghost(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#339933"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "m");
    }

    public Position move(Map map){
        Random random = new Random();
        while(true) {
            Position ret = new Position(this.getPosition().getX() + random.nextInt(3) - 1,
                    this.getPosition().getY() + random.nextInt(3) - 1);
            if(ret.getX() > 0 && ret.getX() < map.getWidth()-1 &&
                    ret.getY() > 0 && ret.getY() < map.getHeight()-1)
                return ret;
        }
    }

}
