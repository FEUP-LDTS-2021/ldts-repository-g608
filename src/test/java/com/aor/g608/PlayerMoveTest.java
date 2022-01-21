package com.aor.g608;

import com.aor.g608.model.game.Position;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMoveTest {
    @Test
    public void MovePlayerTest() {
        Map map = new Map(7,7);
        Position playerPosition = new Position(6,7);
        Player player = new Player(playerPosition, "yellow");
        map.movePlayer(map.moveUp());
        assertEquals(false,map.canPlayerMove(player.getPosition()));
    }
}
