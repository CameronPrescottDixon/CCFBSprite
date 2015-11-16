package com.ccfb.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite extends ApplicationAdapter {
	private SpriteBatch spbOP;
	private Texture txtOP;


	public void create () {
		txtOP = new Texture(Gdx.files.internal("img/OP.jpg"));
		spbOP = new SpriteBatch();
	}

	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spbOP.begin();
		spbOP.draw(txtOP, 10, 10);
		spbOP.end();
	}
}
