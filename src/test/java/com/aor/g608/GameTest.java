package com.aor.g608;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static groovy.test.GroovyTestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class GameTest {


    @Test
    public void DimensionTest() throws IOException {
        Game game = new Game(40, 20, 30);
        assertEquals(40, game.getWidth());
        game.setHeight(60);
        assertEquals(60, game.getHeight());

    }
}
