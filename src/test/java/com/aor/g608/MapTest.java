package com.aor.g608;

import com.aor.g608.model.Position;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Wall;
import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class MapTest {

    @Test
    public void add(){

        Position wall1Position = new Position(0,0);
        Position wall2Position = new Position(1,1);
        Position wall3Position = new Position(2,2);
        Position wall4Position = new Position(3,3);
        Position wall5Position = new Position(4,4);
        Position wall6Position = new Position(5,5);



        Map map = new Map(12, 43);
        Wall wall1 = new Wall(wall1Position, "blue");
        Wall wall2 = new Wall(wall2Position, "blue");
        Wall wall3 = new Wall(wall3Position, "blue");
        Wall wall4 = new Wall(wall4Position, "blue");
        Wall wall5 = new Wall(wall5Position, "blue");
        Wall wall6 = new Wall(wall6Position, "blue");


        map.addWall(wall1);
        map.addWall(wall2);
        map.addWall(wall3);
        map.addWall(wall4);
        map.addWall(wall5);
        map.addWall(wall6);

        assertEquals(6, map.getWalls().size());


    }
}
