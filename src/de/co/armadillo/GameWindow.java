package de.co.armadillo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameWindow extends Game{

	public SpriteBatch batch;
	public ShapeRenderer shape;
	public OrthographicCamera cam;
	
	@Override
	public void create() {
		
		// Create camera
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		// Set batcher, necessary for drawing sprites
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Set shaprenderer, necessary for drawing shapes
		shape = new ShapeRenderer();
		shape.setProjectionMatrix(cam.combined);
		
		AssetLoader.load();
		setScreen(new GameCredits(this));
	}
	
	@Override
	public void dispose() {
		AssetLoader.dispose();
	}
	
}
