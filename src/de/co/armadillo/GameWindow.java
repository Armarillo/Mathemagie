package de.co.armadillo;

import com.badlogic.gdx.Game;

public class GameWindow extends Game{

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
	
}
