package com.tsunderebug.smw.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.tsunderebug.smw.Resources;

public class LoadingState implements GameState {

    private String[] names;
    private int progress = 0;

    @Override
    public void onChange() {
        names = new String[]{
                "super",
                "multi",
                "world"
        };
    }

    @Override
    public GameState nextState() {
        float completion = ((float) progress) / ((float) names.length);
        Gdx.gl.glClearColor(completion, completion, completion, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_CLEAR_VALUE);
        Resources.getResource(names[progress]);
        progress++;
        if(progress >= names.length) {
            return new MenuState();
        } else {
            return this;
        }
    }
}
