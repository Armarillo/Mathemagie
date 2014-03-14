package de.co.armadillo;

import java.util.Random;

public class GameWorld {

	private GameCharacter character;
	private Enemy enemy;
	
	private Random r;
	
	private float accel = 150;
	
	public GameWorld() {
		
		r = new Random();
		
		character = new GameCharacter(720/2-50, 700);
		enemy = new Enemy(r.nextInt(720), accel);
	}
	
	// Responsible for updating variables, controlling the game state
	public void update(float delta) {
		character.update();
		enemy.update(delta);
	}

	public GameCharacter getChar() {
		return character;
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
}
