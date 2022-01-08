package com.aor.g608;

import com.aor.g608.model.Position;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    public static Position position;
    public static Pair<Position, String> ghost;

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public Element(int x, int y, String color){
        position = new Position(x, y);
        ghost = new Pair<>(position, color);
    }

    public static Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics screen);
}
