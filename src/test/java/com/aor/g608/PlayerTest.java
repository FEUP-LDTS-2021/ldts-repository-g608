package com.aor.g608;

import org.junit.jupiter.api.Test;

import static groovy.test.GroovyTestCase.assertEquals;

public class PlayerTest {

    @Test
    public void PlayerTest(){
        Player player = new Player(5, 3);
        assertEquals(5, player.getPosition().getX());

    }
}
