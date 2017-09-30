package com.tsunderebug.smw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tsunderebug.smw.state.GameState;
import com.tsunderebug.smw.state.LoadingState;

public class SuperMultiWorld extends ApplicationAdapter {

    private GameState s;

	@Override
	public void create () {
		s = new LoadingState();
		s.onChange();
	}

	@Override
	public void render () {
		GameState ns = s.nextState();
		if(ns != s) {
		    ns.onChange();
        }
        s = ns;
	}

}
