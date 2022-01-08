package com.aor.g608;

import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Wall;
import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class MapTest {

    @Test
    public void add(){
        Map map = new Map(12, 43);
        Wall wall1 = new Wall(0, 0);
        Wall wall2 = new Wall(1, 1);
        Wall wall3 = new Wall(2, 2);
        Wall wall4 = new Wall(3, 3);
        Wall wall5 = new Wall(4, 4);
        Wall wall6 = new Wall(5, 5);


        map.addWall(wall1);
        map.addWall(wall2);
        map.addWall(wall3);
        map.addWall(wall4);
        map.addWall(wall5);
        map.addWall(wall6);

        assertEquals(6, map.getWalls().size());


    }
}
