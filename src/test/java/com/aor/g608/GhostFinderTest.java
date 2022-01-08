package com.aor.g608;

import com.aor.g608.model.Position;
import com.aor.g608.model.game.Ghost;
import com.aor.g608.model.game.GhostDatabase;
import com.aor.g608.model.game.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GhostFinderTest {
    private GhostDatabase stubGhostDatabase;

    @BeforeEach
    public void setUp() throws Exception {
        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ghost(1, 5, "Orange"));
        ghosts.add(new Ghost(1, 4, "Pink"));
        ghosts.add(new Ghost(2, 6, "Cyan"));
        ghosts.add(new Ghost(5, 7, "Red"));

        stubGhostDatabase = Mockito.mock(GhostDatabase.class);
        Mockito.when(stubGhostDatabase.getAllGhosts()).thenReturn(ghosts);
    }

    @Test
    public void findGhost() throws Exception {
        Map map = new  Map(10, 20);
        map.GhostFinder(stubGhostDatabase);
        Assertions.assertTrue(map.findGhost("Red"));
    }
}
