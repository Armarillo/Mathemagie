package de.co.armadillo.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

	public static TextureRegion cross;
	public static Texture bg;
	
	public static TextureRegion credits;
	public static TextureRegion armadillo;
	
	public static BitmapFont font;
	public static BitmapFont highFont;
	public static BitmapFont bigFont;
	
	public static TextureRegion health;
	
	public static TextureRegion title;
	public static TextureRegion pi;
	public static TextureRegion binomial;
	public static TextureRegion complex;
	public static TextureRegion squareroot;
	
	public static Sound menuMusic;
	
	public static Skin skin;
	
	public static void load() {
		
		// Remove enforcement
		Texture.setEnforcePotImages(false);
		
		// Cross
		cross = new TextureRegion(new Texture(Gdx.files.internal("data/game/cross.png")));
		
		// Font
		font = new BitmapFont();
		font.setScale(1, -1);
		
		// Highscore font
		highFont = new BitmapFont(Gdx.files.internal("data/font/font.fnt"), new TextureRegion(new Texture(Gdx.files.internal("data/font/font.png"))), false);
		highFont.setScale(1, -1);

		// Highscore font
		bigFont = new BitmapFont(Gdx.files.internal("data/font/bigfont.fnt"), new TextureRegion(new Texture(Gdx.files.internal("data/font/bigfont.png"))), false);
		bigFont.setScale(1, -1);
		
		// Background
		bg = new Texture("data/game/background.png");
	
		// Armadillo picture
		armadillo = new TextureRegion(new Texture(Gdx.files.internal("data/menu/armadillo.png")));
		armadillo.flip(false, true);
		
		// Health
		health = new TextureRegion(new Texture(Gdx.files.internal("data/game/health.png")));
		health.flip(false, true);
		
		// Name
		credits = new TextureRegion(new Texture(Gdx.files.internal("data/menu/credits.png")));
		credits.flip(false, true);
		
		// Music
		menuMusic = Gdx.audio.newSound(Gdx.files.internal("data/misc/menumusic.wav"));
		
		// Skin
		skin = new Skin(Gdx.files.internal("data/misc/uiskin.json"));
		
		// Title
		title = new TextureRegion(new Texture(Gdx.files.internal("data/menu/title.png")));
		title.flip(false, true);
		
		// Mathmatical signs
		pi = new TextureRegion(new Texture(Gdx.files.internal("data/menu/pi.png")));
		pi.flip(false, true);
		
		binomial = new TextureRegion(new Texture(Gdx.files.internal("data/menu/a2abb.png")));
		binomial.flip(false, true);
		
		complex = new TextureRegion(new Texture(Gdx.files.internal("data/menu/abi.png")));
		complex.flip(false, true);
		
		squareroot = new TextureRegion(new Texture(Gdx.files.internal("data/menu/squareroot.png")));
		squareroot.flip(false, true);
		
	}
	
	public static void dispose() {
		font.dispose();
		bg.dispose();
		menuMusic.dispose();
		
		
	}
}
