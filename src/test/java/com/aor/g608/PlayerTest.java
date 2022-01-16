package com.aor.g608;

import com.aor.g608.model.Position;
import com.aor.g608.model.game.Player;
import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class PlayerTest {

    @Test
    public void PlayerTest(){
        Position playerPosition = new Position(5, 3);
        Player player = new Player(playerPosition, "yellow");
        assertEquals(5, player.getPosition().getX());

    }
}
