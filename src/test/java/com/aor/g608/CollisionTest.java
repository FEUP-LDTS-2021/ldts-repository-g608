package com.aor.g608;

import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Position;
import com.aor.g608.model.ghost.Ghost;
import com.aor.g608.model.wall.Wall;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.Test;
import org.w3c.dom.css.Rect;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CollisionTest {
    @Property
    public void testGetHitbox(@ForAll int width, @ForAll int height){
        Wall wall = new Wall(width, height);
        //assertEquals(subject.getHitbox(), new Wall(width, height));
    }


    @Test
    public void testCollisionCheck() throws FileNotFoundException {

       // Position position = new Position(0, 0);
       // Ghost ghost1 = new Ghost(3, 3);
       // Map map = new Map(3, 4, null);
       // map.
       // Wall wall = new Wall(3 , 3);


       // assertFalse();
    }
}
