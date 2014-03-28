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
		
		// Get instance of world
		this.world = world;
		
		// Camera
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		// Pencil
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Make stage
		stage = new Stage();
		
		// Button
		TextButton restart = new TextButton("Restart", AssetLoader.skin);
		restart.setSize(145, 50);
		restart.setPosition(155, 350);
		restart.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameScreen(window));
			}
		});
		stage.addActor(restart);
		
		// Button
		TextButton menu = new TextButton("Menu", AssetLoader.skin);
		menu.setSize(145, 50);
		menu.setPosition(370, 350);
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
		batch.draw(AssetLoader.bg, world.getBackground().getX(), world.getBackground().getY()-840);
		
		// Draw message
		AssetLoader.bigFont.draw(batch, "Game Over", 230, 300);
		
		// Draw score
		AssetLoader.highFont.draw(batch, "Score: " + GameState.lastScore, 230, 350);
		
		// Draw stage
		AssetLoader.highFont.draw(batch, "Stage: " + GameState.lastStage, 230, 375);
		
		batch.end();
		
		// Draw stage
		stage.act(delta);
		stage.draw();
		
		// Put on screen
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {}

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
