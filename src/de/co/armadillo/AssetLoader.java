package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static TextureRegion cross;
	public static Texture bg;
	
	public static TextureRegion credits;
	
	public static BitmapFont font;
	public static BitmapFont fontTitle;
	
	public static Music music;
	
	public static void load() {
		
		// Remove enforcement
		Texture.setEnforcePotImages(false);
		
		// Cross
		cross = new TextureRegion(new Texture(Gdx.files.internal("data/cross.png")));
		
		// Font
		font = new BitmapFont();
		font.setScale(1, -1);

		// Font for title
		fontTitle = new BitmapFont();
		fontTitle.setScale(2, -2);
		
		// Background
		bg = new Texture("data/background.png");
	
		// Armadillo picture
		credits = new TextureRegion(new Texture(Gdx.files.internal("data/credits.png")));
		credits.flip(false, true);
		
		// Music
		music = Gdx.audio.newMusic(Gdx.files.internal("data/Quacker Jack Stage.wav"));
		
	}
	
	public static void dispose() {
		font.dispose();
		fontTitle.dispose();
		bg.dispose();
		music.dispose();
		
		
	}
}
