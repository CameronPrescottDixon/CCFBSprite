package com.ccfb.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ccfb.game.ManySprites;
import com.ccfb.game.Sprite;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ManySprites(), config);
		//new LwjglApplication(new Sprites(), config);
	}
}
