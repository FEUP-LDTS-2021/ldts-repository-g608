package com.aor.g608.model.game;

public class Player extends Element {

    public Player(int x, int y) {
        super(x, y);
    }

    public Position moveUp() {return new Position(position.getX(),position.getY()-1);}
    public Position moveDown() {return new Position(position.getX(),position.getY()+1);}
    public Position moveRight() {return new Position(position.getX()+1,position.getY());}
    public Position moveLeft() {return new Position(position.getX()-1,position.getY());}

}
