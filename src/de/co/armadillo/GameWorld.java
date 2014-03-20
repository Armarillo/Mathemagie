package de.co.armadillo;

import java.util.Random;

public class GameWorld {

	private Random r;
	private Target target;
	private Enemy[] enemy;
	private Background background;
	private GameCharacter character;
	
	// Amount of enemies
	private int amount = 1;
	
	public GameWorld() {
		
		r = new Random();
		target = new Target();
		enemy = new Enemy[amount];
		background = new Background(0, 0, 10);
		character = new GameCharacter(310, 700, target);
		
		// Initialize enemies
		for(int i = 0; i < enemy.length; i++)
			enemy[i] = new Enemy(r.nextInt(720), -r.nextInt(400), 50 + r.nextInt(100));
	}
	
	// Responsible for updating variables, controlling the game state
	public void update(float delta) {
		
		// Update background
		background.update(delta);
		
		// Update enemies
		for(int i = 0; i < enemy.length; i++)
			enemy[i].update(delta);
		
		// Update aiming
		target.update(enemy[0]); // TODO: Switching enemies
	}

	public GameCharacter getChar() {
		return character;
	}
	
	public Enemy[] getEnemy() {
		return enemy;
	}
	
	public Target getAim() {
		return target;
	}

	public Background getBackground() {
		return background;
	}
}
