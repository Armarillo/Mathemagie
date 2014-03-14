package de.co.armadillo;

import java.util.Random;

public class GameWorld {

	private GameCharacter character;
	private Enemy[] enemy;
	
	private Random r;
	
	private int amount = 5;
	
	public GameWorld() {
		
		r = new Random();
		enemy = new Enemy[amount];
		character = new GameCharacter(720/2-50, 700);
		
		// Initialize enemies
		for(int i = 0; i < enemy.length; i++)
			enemy[i] = new Enemy(r.nextInt(720), -r.nextInt(400), 50 + r.nextInt(100));
								/*   width            height      velocity */
	}
	
	// Responsible for updating variables, controlling the game state
	public void update(float delta) {
		character.update();
		for(int i = 0; i < enemy.length; i++)
			enemy[i].update(delta);
	}

	public GameCharacter getChar() {
		return character;
	}
	
	public Enemy[] getEnemy() {
		return enemy;
	}
}
