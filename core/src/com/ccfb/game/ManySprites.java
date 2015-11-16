/*
The following code has been modified
from SFB's original Drop project
 */
package com.ccfb.game;

import java.util.Iterator;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class ManySprites implements ApplicationListener {

    private Texture txtOP;
    private SpriteBatch spbOP;
    private OrthographicCamera orthoCam;
    private Array<Rectangle> arrOP;
    private long lastDropTime;
    private BitmapFont font;
    private int spawnMillis;


    @Override
    public void create() {
        txtOP = new Texture("img/OP.jpg");
        font = new BitmapFont();
        spawnMillis = 1000;

        orthoCam = new OrthographicCamera();
        orthoCam.setToOrtho(false, 800, 480);
        spbOP = new SpriteBatch();

        arrOP = new Array<Rectangle>();
        spawnarrOP();
    }

    private void spawnarrOP() {
        Rectangle rectOP = new Rectangle();
        rectOP.x = MathUtils.random(0, 800 - 64);
        rectOP.y = 480;
        rectOP.width = 64;
        rectOP.height = 64;
        arrOP.add(rectOP);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        orthoCam.update();

        spbOP.setProjectionMatrix(orthoCam.combined);

        spbOP.begin();
        for (Rectangle raindrop : arrOP) {
            spbOP.draw(txtOP, raindrop.x, raindrop.y);
        }
        spbOP.end();

        spawnMillis = 1000;
        if (TimeUtils.nanoTime() - lastDropTime > 1000000 * spawnMillis) spawnarrOP();

        Iterator<Rectangle> iter = arrOP.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= (150 + 2) * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0) {
                iter.remove();
            }
        }
    }

    @Override
    public void dispose() {
        txtOP.dispose();
        spbOP.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}