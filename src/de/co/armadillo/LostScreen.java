package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LostScreen implements Screen{

	private SpriteBatch batch;
	private OrthographicCamera cam;
	private Stage stage;
	private GameWorld world;
	
	public LostScreen(final GameWindow window, GameWorld world) {
		
		this.world = world;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Make stage
		stage = new Stage();
		
		// Buttons
		TextButton restart = new TextButton("Restart", AssetLoader.skin);
		restart.setSize(125, 50);
		restart.setPosition(125, 350);
		restart.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameScreen(window));
			
			}
		});
		stage.addActor(restart);
		
		TextButton menu = new TextButton("Menu", AssetLoader.skin);
		menu.setSize(125, 50);
		menu.setPosition(400, 350);
		menu.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameMenu(window));
			
			}
		});
		stage.addActor(menu);
	}
	
	@Override
	public void render(float delta) {
		
		// Clear screen
		Gdx.gl.glClearColor(0/255.0f, 0/255.0f, 0/255.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();

		// Draw background
		batch.draw(AssetLoader.bg, world.getBackground().getX(), world.getBackground().getY());

		// Draw text
		AssetLoader.bigFont.draw(batch, "Game Over", 225, 300);
		
		batch.end();
		
		// Draw stage
		stage.act(delta);
		stage.draw();
		
		
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
