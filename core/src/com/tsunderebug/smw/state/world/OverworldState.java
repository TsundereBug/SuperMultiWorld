package com.tsunderebug.smw.state.world;

import com.tsunderebug.smw.frame.world.OverworldMap;
import com.tsunderebug.smw.state.GameState;

public class OverworldState implements GameState {

    private OverworldMap m;

    public OverworldState(OverworldMap m) {
        this.m = m;
    }

    @Override
    public void onChange() { // TODO

    }

    @Override
    public GameState nextState() { // TODO
        return null;
    }

    public OverworldMap getOverworld() {
        return this.m;
    }

}
