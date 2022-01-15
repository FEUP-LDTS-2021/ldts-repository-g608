package com.aor.g608.state.Interaction;

import com.aor.g608.model.Position;

public interface MouseInter {
    Position click(Position position);
    void move(Position position);
}
