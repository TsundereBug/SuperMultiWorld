package com.tsunderebug.smw.state;

public interface GameState {

    void onChange();

    /*
    Gets called every frame; if menu option is pressed move to next state
     */
    GameState nextState();

}
