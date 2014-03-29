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

public class GameMenu implements Screen{

	private SpriteBatch batch;
	private OrthographicCamera cam;
	private Stage stage;
	
	public GameMenu(final GameWindow window) {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Play music
		AssetLoader.menuMusic.loop();

		
		// Make stage
		stage = new Stage();
		
		// Buttons
		TextButton play = new TextButton("Play", AssetLoader.skin);
		play.setSize(275, 50);
		play.setPosition(223, 550);
		play.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.menuMusic.stop();
				window.setScreen(new GameScreen(window));
			
			}
		});
		stage.addActor(play);
		
		// Buttons
		TextButton option = new TextButton("Options", AssetLoader.skin);
		option.setSize(275, 50);
		option.setPosition(223, 475);
		stage.addActor(option);
		
		// Buttons
		TextButton credits = new TextButton("Credits", AssetLoader.skin);
		credits.setSize(275, 50);
		credits.setPosition(223, 400);
		stage.addActor(credits);

		// Buttons		
		TextButton quit = new TextButton("Quit", AssetLoader.skin);
		quit.setSize(275, 50);
		quit.setPosition(223, 325);
		quit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.exit(0);
			}
		});
		stage.addActor(quit);
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

		// title
		batch.draw(AssetLoader.title, 136, 100, 0, 0, 299, 57, 1.5f, 1.5f, 0);
		
		// pi
		batch.draw(AssetLoader.pi, 100, 200, 0, 0, 168, 160, 0.25f, 0.25f, -10);
		
		// binomial
		batch.draw(AssetLoader.binomial, 400, 570, 0, 0, 83, 20, 1, 1, 10);
		
		// complex
		batch.draw(AssetLoader.complex, 500, 20, 0, 0, 35, 18, 1, 1, -5);
		
		// square root
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
