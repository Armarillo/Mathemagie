package de.co.armadillo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.co.armadillo.engine.AssetLoader;
import de.co.armadillo.engine.GameState;
import de.co.armadillo.engine.GameWindow;

public class DifficultyScreen implements Screen{

	private SpriteBatch batch;
	private OrthographicCamera cam;
	private Stage stage;
	
	public DifficultyScreen(final GameWindow window) {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Make stage
		stage = new Stage();
		
		// Easy Button
		TextButton play = new TextButton("Rookie", AssetLoader.skin);
		play.setSize(275, 50);
		play.setPosition(223, 550);
		play.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.click.play();
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameScreen(window));
				GameState.difficulty = 0;
			}
		});
		stage.addActor(play);
		
		// Medium Button
		TextButton option = new TextButton("Mathter", AssetLoader.skin);
		option.setSize(275, 50);
		option.setPosition(223, 450);
		option.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.click.play();
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameScreen(window));
				GameState.difficulty = 1;
			}
		});
		stage.addActor(option);
		
		// Hard Button
		TextButton credits = new TextButton("Impossibru", AssetLoader.skin);
		credits.setSize(275, 50);
		credits.setPosition(223, 350);
		credits.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.click.play();
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameScreen(window));
				GameState.difficulty = 2;
			}
		});
		stage.addActor(credits);
	}
	
	@Override
	public void render(float delta) {
		
		// Clear screen
		Gdx.gl.glClearColor(0/255.0f, 0/255.0f, 0/255.0f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Add stage
		stage.act(delta);
		stage.draw();
		
		batch.begin();

		batch.draw(AssetLoader.title, 136, 100, 0, 0, 299, 57, 1.5f, 1.5f, 0);
		batch.draw(AssetLoader.pi, 100, 200, 0, 0, 168, 160, 0.25f, 0.25f, -10);
		batch.draw(AssetLoader.binomial, 400, 570, 0, 0, 83, 20, 1, 1, 10);
		batch.draw(AssetLoader.complex, 500, 20, 0, 0, 35, 18, 1, 1, -5);
		batch.draw(AssetLoader.squareroot, 100, 700, 0, 0, 120, 94, 1, 1, 5);
		
		batch.end();
		
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
