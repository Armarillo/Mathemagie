package de.co.armadillo;

import com.badlogic.gdx.Game;

public class GameWindow extends Game{

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		AssetLoader.dispose();
	}
	
}
