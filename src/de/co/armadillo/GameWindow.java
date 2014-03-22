package de.co.armadillo;

import com.badlogic.gdx.Game;

public class GameWindow extends Game{

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameCredits(this));
	}
	
	@Override
	public void dispose() {
		AssetLoader.dispose();
	}
	
}
