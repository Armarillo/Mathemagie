package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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
	
	public static TextureRegion title;
	
	public static TextureRegion health;
	
	public static TextureRegion pi;
	public static TextureRegion binomial;
	public static TextureRegion complex;
	public static TextureRegion squareroot;
	
	public static Music menuMusic;
	public static Music gameMusic;
	
	public static Skin skin;
	
	public static void load() {
		
		// Remove enforcement
		Texture.setEnforcePotImages(false);
		
		// Cross
		cross = new TextureRegion(new Texture(Gdx.files.internal("data/cross.png")));
		
		// Font
		font = new BitmapFont();
		font.setScale(1, -1);
		
		// Highscore font
		highFont = new BitmapFont(Gdx.files.internal("data/font.fnt"), new TextureRegion(new Texture(Gdx.files.internal("data/font.png"))), false);
		highFont.setScale(1, -1);

		// Highscore font
		bigFont = new BitmapFont(Gdx.files.internal("data/font.fnt"), new TextureRegion(new Texture(Gdx.files.internal("data/font.png"))), false);
		bigFont.setScale(2, -2);
		
		// Background
		bg = new Texture("data/background.png");
	
		// Armadillo picture
		armadillo = new TextureRegion(new Texture(Gdx.files.internal("data/armadillo.png")));
		armadillo.flip(false, true);
		
		// Health
		health = new TextureRegion(new Texture(Gdx.files.internal("data/health.png")));
		health.flip(false, true);
		
		// Name
		credits = new TextureRegion(new Texture(Gdx.files.internal("data/credits.png")));
		credits.flip(false, true);
		
		// Music
		menuMusic = Gdx.audio.newMusic(Gdx.files.internal("data/menuMusic.wav"));
		//gameMusic = Gdx.audio.newMusic(Gdx.files.internal("data/gameMusic.wav"));
		
		// Skin
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		// Title
		title = new TextureRegion(new Texture(Gdx.files.internal("data/title.png")));
		title.flip(false, true);
		
		// Mathmatical signs
		pi = new TextureRegion(new Texture(Gdx.files.internal("data/pi.png")));
		pi.flip(false, true);
		
		binomial = new TextureRegion(new Texture(Gdx.files.internal("data/a2abb.png")));
		binomial.flip(false, true);
		
		complex = new TextureRegion(new Texture(Gdx.files.internal("data/abi.png")));
		complex.flip(false, true);
		
		squareroot = new TextureRegion(new Texture(Gdx.files.internal("data/squareroot.png")));
		squareroot.flip(false, true);
		
	}
	
	public static void dispose() {
		font.dispose();
		bg.dispose();
		menuMusic.dispose();
		
		
	}
}
