package de.co.armadillo;

public class GameWorld {

	private GameCharacter character;
	
	public GameWorld() {
		character = new GameCharacter(720/2-50, 700);
	}
	
	// Responsible for updating variables, controlling the game state
	public void update() {
		character.update();
	}

	public GameCharacter getChar() {
		return character;
	}
}
