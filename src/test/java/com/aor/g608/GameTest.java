package com.aor.g608;

import com.aor.g608.model.game.Map;
import com.aor.g608.viewer.game.MapViewer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

import static groovy.test.GroovyTestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class GameTest {

    @BeforeAll
    static void init() throws IOException, SAXException, ParserConfigurationException {
        //MapViewer gui = Mockito.mock(MapViewer.class);
        //Map map = new Map(20, 20, m);
    }

    @Test
    public void DimensionTest() throws IOException, FontFormatException {
        Game game;
        game = new Game(40, 20);
        assertEquals(40, game.getWidth());
        game.setHeight(60);
        assertEquals(60, game.getHeight());

    }
}
