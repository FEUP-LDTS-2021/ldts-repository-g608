package com.aor.g608;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static groovy.test.GroovyTestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class GameTest {


    @Test
    public void DimensionTest() throws IOException, FontFormatException {
        Game game;
        game = new Game(40, 20);
        assertEquals(40, game.getWidth());
        game.setHeight(60);
        assertEquals(60, game.getHeight());

    }
}
