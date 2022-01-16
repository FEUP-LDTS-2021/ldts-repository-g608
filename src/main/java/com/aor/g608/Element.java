package com.aor.g608;

import com.aor.g608.model.Position;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    public Position position;
    public String color;

    public Element(Position position, String color){
        this.position = position;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
