package com.aor.g608;

import com.aor.g608.model.game.Position;
import com.aor.g608.model.game.Map;
import com.aor.g608.model.game.Player;
import org.junit.jupiter.api.Test;
import org.junit.validator.ValidateWith;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMoveTest {
    @Test
    public void MovePlayerTest() throws FileNotFoundException {
       Map map = new Map(7,7, null);
       Player player = new Player(4, 4);
       map.movePlayer(map.moveUp());
       assertEquals(false,map.canPlayerMove(player.getPosition()));
    }

    @Test
    public void PlayerMoveUpTest(){
        Player player = new Player(5,5);
        assertEquals(4,player.moveUp().getY());
    }

    @Test
    public void PlayerMoveLeftTest(){
        Player player = new Player(5,5);
        assertEquals(4, player.moveLeft().getX());
    }

    @Test
    public void PlayerMoveDownTest(){
        Player player = new Player(5,5);
        assertEquals(6, player.moveDown().getY());
    }

    @Test
    public void PlayerMoveRightTest(){
        Player player = new Player(5,5);
        assertEquals(6, player.moveRight().getX());
    }


}

