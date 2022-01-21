package com.aor.g608.model;

import com.aor.g608.model.game.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static groovy.test.GroovyTestCase.assertEquals;

public class ButtonTest {

    @Test
    void getY() {
        Position position = new Position(3, 4);
        List<String> colors = new ArrayList<>();
        colors.add("blue");
        colors.add("red");
        colors.add("yellow");
        Button button = new Button(position, "play", colors);
        assertEquals(4, button.getTextPosition().getY());
    }
}
