package com.aor.g608;

import com.aor.g608.model.Position;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    public Position position;

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics screen);
}
