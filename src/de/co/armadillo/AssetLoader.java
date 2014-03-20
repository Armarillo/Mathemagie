package de.co.armadillo;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {

	public static BitmapFont font;
	
	public static void load() {
		font = new BitmapFont();
		font.setScale(1, -1);
	}
	
	public static void dispose() {
		font.dispose();
	}
}
