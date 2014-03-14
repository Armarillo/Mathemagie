package de.co.armadillo;

import java.util.Random;

public class GameWorld {

	private GameCharacter character;
	private Enemy[] enemy;
	
	private Random r;
	
	private int amount = 5;
	
	public GameWorld() {
		
		r = new Random();
		
		character = new GameCharacter(720/2-50, 700);
		enemy = new Enemy[amount];
		for(int i = 0; i < enemy.length; i++)
			enemy[i] = new Enemy(r.nextInt(720), -r.nextInt(400), r.nextInt(200));
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
