package com.aor.g608.model;

import com.aor.g608.model.game.Position;
import com.aor.g608.model.wall.Wall;

import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class WallTest {
    @Test
    public void WallTest(){
        Position wallPosition = new Position(4, 3);

        Wall wall = new Wall(wallPosition, "blue");
        assertEquals(4, wall.getPosition().getX());
        Position position = new Position(2, 1);
        wall.setPosition(position);
        assertEquals(1, wall.getPosition().getY());
    }
}
