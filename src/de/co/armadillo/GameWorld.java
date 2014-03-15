package de.co.armadillo;

import java.util.Random;

public class GameWorld {

	private Random r;
	private Aiming aim;
	private Enemy[] enemy;
	private GameCharacter character;
	
	// Amount of enemies
	private int amount = 1;
	
	public GameWorld() {
		
		r = new Random();
		aim = new Aiming(335, 725);
		enemy = new Enemy[amount];
		character = new GameCharacter(310, 700, aim);
		
		// Initialize enemies
		for(int i = 0; i < enemy.length; i++)
			enemy[i] = new Enemy(r.nextInt(720), -r.nextInt(400), 50 + r.nextInt(100));
								/*   width            height      velocity */
	}
	
	// Responsible for updating variables, controlling the game state
	public void update(float delta) {
		
		// Update enemies
		for(int i = 0; i < enemy.length; i++)
			enemy[i].update(delta);
		
		// Update aiming
		aim.update(enemy[0]); // TODO: Switching enemies
	}

	public GameCharacter getChar() {
		return character;
	}
	
	public Enemy[] getEnemy() {
		return enemy;
	}
	
	public Aiming getAim() {
		return aim;
	}
}
