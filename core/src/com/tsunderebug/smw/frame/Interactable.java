package com.tsunderebug.smw.frame;

import com.tsunderebug.smw.state.GameState;

public interface Interactable<S extends GameState> {

    void upPressed(S s);
    void downPressed(S s);
    void leftPressed(S s);
    void rightPressed(S s);
    void aPressed(S s);
    void bPressed(S s);
    void xPressed(S s);
    void yPressed(S s);

}
