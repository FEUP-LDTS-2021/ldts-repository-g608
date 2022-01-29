package com.aor.g608;

import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import java.io.FileNotFoundException;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Positive;


public class MapTest {

    @Property
    public void testMapBounds(@ForAll @IntRange(min = 1, max = 100) int width, @ForAll @IntRange(min = 1, max = 100) int height, @ForAll @Positive int x, @ForAll @Positive int y) throws FileNotFoundException {
        Map map = new Map(width, height, null);

        assert (x >= 0 || !map.isInBounds(new Position(x, y)));
        assert (y >= 0 || !map.isInBounds(new Position(x, y)));
        assert (x < map.getWidth() || !map.isInBounds(new Position(x, y)));
        assert (y < map.getHeight() || !map.isInBounds(new Position(x, y)));
    }
}


//@Property
//public void canPlayerMove(@ForAll Position position) {
//       assert(canPlayerMove(position))}
//      }

//@Property
//public void playerpositionmoveup(@ForAll Position position) {
//        assert(position.getX() > 0);
//        assert(position.getY() > 0);
//}
//}