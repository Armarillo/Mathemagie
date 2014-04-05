package de.co.armadillo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.co.armadillo.engine.AssetLoader;
import de.co.armadillo.engine.GameState;
import de.co.armadillo.engine.GameWindow;

public class OptionScreen implements Screen{

	private SpriteBatch batch;
	private OrthographicCamera cam;
	private Stage stage;
	
	public OptionScreen(final GameWindow window) {
		
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		// Make stage
		stage = new Stage();
		
		String label;
		
		if(GameState.musicMute) label = "  OFF";
		else label = "  ON";
		
		// Textfield for sound
		final TextField tfSound = new TextField(label, AssetLoader.skin);
		tfSound.setDisabled(true);
		tfSound.setPosition(430, 550);
		tfSound.setSize(55, 50);
		tfSound.setMaxLength(9);
		stage.addActor(tfSound);
		
		if(GameState.soundMute) label = "  OFF";
		else label = "  ON";
		
		// Textfield for sfx
		final TextField tfSFX = new TextField(label, AssetLoader.skin);
		tfSFX.setDisabled(true);
		tfSFX.setPosition(430, 475);
		tfSFX.setSize(55, 50);
		tfSFX.setMaxLength(9);
		stage.addActor(tfSFX);
		
		// Textfield for fullscreen
		final TextField tfFullscreen = new TextField("  OFF", AssetLoader.skin);
		tfFullscreen.setDisabled(true);
		tfFullscreen.setPosition(430, 400);
		tfFullscreen.setSize(55, 50);
		tfFullscreen.setMaxLength(9);
		stage.addActor(tfFullscreen);
		
		// Button for muting music
		TextButton muteMusic = new TextButton("Music", AssetLoader.skin);
		muteMusic.setSize(175, 50);
		muteMusic.setPosition(230, 550);
		muteMusic.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				AssetLoader.click.play();
				
				// Mute
				if(!GameState.musicMute) {
					AssetLoader.menuMusic.stop();
					GameState.musicMute = true;
					tfSound.setText("  OFF");

				// Unmute
				}else{
					AssetLoader.menuMusic.stop();
					AssetLoader.menuMusic.loop();
					GameState.musicMute = false;
					tfSound.setText("  ON");
				}
			}
		});
		stage.addActor(muteMusic);
		
		// Button for muting sound
		TextButton muteSound = new TextButton("SFX", AssetLoader.skin);
		muteSound.setSize(175, 50);
		muteSound.setPosition(230, 475);
		muteSound.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.click.play();
				if(!GameState.soundMute) {
					GameState.soundMute = true;
					tfSFX.setText("  OFF");
					AssetLoader.disposeSound();
				}else{
					GameState.soundMute = false;
					tfSFX.setText("  ON");
					AssetLoader.loadSound();
				}
			}
		});
		stage.addActor(muteSound);

		// Button for toggling fullscreen
		TextButton fullscreen = new TextButton("Fullscreen", AssetLoader.skin);
		fullscreen.setSize(175, 50);
		fullscreen.setPosition(230, 400);
		/*fullscreen.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				AssetLoader.click.play();
				if(!GameState.fullscreen) {
					Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, true);
					GameState.fullscreen = true;
					tfFullscreen.setText("  ON");
				}else{
					Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, false);
					GameState.fullscreen = false;
					tfFullscreen.setText("  OFF");
				}
			}
		});*/
		stage.addActor(fullscreen);

		// Back button		
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
