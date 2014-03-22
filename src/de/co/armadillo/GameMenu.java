package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class GameMenu implements Screen{

	private SpriteBatch batch;
	
	private OrthographicCamera cam;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0/255.0f, 0/255.0f, 0/255.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		
		AssetLoader.fontTitle.draw(batch, "Mathemagie", 100, 100);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
	
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
