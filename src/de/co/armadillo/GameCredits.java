package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameCredits implements Screen {

	private SpriteBatch batch;
	private OrthographicCamera cam;
	private GameWindow window;
	
	private float fade;
	
	private float runTime;
	private float lastTime;
	
	public GameCredits(GameWindow window) {

		// Instance of window
		this.window = window;
		
		// Create camera
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		// Use our "pencil" on camera
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Variable for fade in/ and out
		fade = 0;
		
		// Timekeeping variable
		runTime = 0;
		lastTime = 0;
	}
	
	@Override
	public void render(float delta) {
		
		// Keep time
		runTime += delta;
		
		// Fade in, as long as its not fully faded, and stop when fade out occures (at 4secs)
		if(runTime <= 2 && fade <= 0.95 && runTime - lastTime >= 0.015) {
			fade+= 0.01;
			lastTime = runTime;
		}
		
		// Fade out
		if(runTime >= 2 && fade >= 0.0001 && runTime - lastTime >= 0.015) {
			fade-= 0.01;
			lastTime = runTime;
		}
		
		// Change screen
		if(runTime >= 5)
			window.setScreen(new GameScreen());
		
		// Clear screen
		Gdx.gl.glClearColor(0/255.0f, 0/255.0f, 0/255.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		batch.setColor(1f, 1f, 1f, fade);
		
		// Draw picture
		batch.draw(AssetLoader.credits, 57, 840/2-57);
		
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}

}
