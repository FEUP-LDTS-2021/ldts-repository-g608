package com.aor.g608.command;

public interface Command {
    boolean execute();
    void undo();
}
