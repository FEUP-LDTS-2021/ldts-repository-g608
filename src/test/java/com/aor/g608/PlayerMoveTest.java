package com.aor.g608;

import com.aor.g608.model.game.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMoveTest {
    @Test
    public void MovePlayerTest() {
        Map map = new Map(7,7);
        Player player = new Player(6,7);
        map.movePlayer(map.moveUp());
        assertEquals(false,map.canPlayerMove(player.getPosition()));
    }
}
