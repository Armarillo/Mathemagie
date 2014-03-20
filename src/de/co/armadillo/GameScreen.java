package de.co.armadillo;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{

	private GameWorld world;
	private GameRenderer renderer;
	
	public GameScreen() {
		
		// Initialize fundament
		world = new GameWorld();
		renderer = new GameRenderer(world);
		
		// Play music
		AssetLoader.music.play();
		AssetLoader.music.setLooping(true);
	}
	
	// The main loop of the game - it's heart, can you hear it beating?
	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render(delta);
	}

	// Window methods
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
