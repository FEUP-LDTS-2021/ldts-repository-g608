package com.aor.g608;

import com.aor.g608.model.Position;
import com.aor.g608.model.game.Wall;

import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class WallTest {
    @Test
    public void WallTest(){
        Wall wall = new Wall(4, 3);
        assertEquals(4, wall.getPosition().getX());
        Position position = new Position(2, 1);
        wall.setPosition(position);
        assertEquals(1, wall.getPosition().getY());
    }
}
