package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {

	public static BitmapFont font;
	public static Texture bg;
	public static Music music;
	
	public static void load() {
		
		// Remove enforcement
		Texture.setEnforcePotImages(false);
		
		// Font
		font = new BitmapFont();
		font.setScale(1, -1);
		
		// Background
		bg = new Texture(Gdx.files.internal("data/background.png"));
	
		// Music
		music = Gdx.audio.newMusic(Gdx.files.internal("data/Quacker Jack Stage.wav"));
		
	}
	
	public static void dispose() {
		font.dispose();
	}
}
