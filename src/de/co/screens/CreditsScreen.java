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
import de.co.armadillo.engine.GameWindow;

public class CreditsScreen implements Screen{

	private SpriteBatch batch;
	private OrthographicCamera cam;
	private Stage stage;
	
	public CreditsScreen(final GameWindow window) {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Make stage
		stage = new Stage();

		// Buttons		
		TextButton back = new TextButton("Back", AssetLoader.skin);
		back.setSize(325, 50);
		back.setPosition(200, 325);
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.click.play();
				window.setScreen(new MenuScreen(window));
			}
		});
		stage.addActor(back);
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
		
		AssetLoader.highFont.setColor(255/255.0f, 165/255.0f, 0/255.0f, 1f);
		AssetLoader.highFont.draw(batch, "Designed and", 223, 240);
		AssetLoader.highFont.draw(batch, "Programmed by", 223, 260);
		AssetLoader.highFont.draw(batch, "Music by", 223, 320);
		AssetLoader.highFont.draw(batch, "For", 223, 380);
		
		AssetLoader.highFont.setColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
		AssetLoader.highFont.draw(batch, "Julien Midedji", 385, 280);
		AssetLoader.highFont.draw(batch, "Jake Chudnow", 380, 340);
		AssetLoader.highFont.draw(batch, "Armadillo Production", 325, 400);
		
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
