package de.co.armadillo;

import com.badlogic.gdx.math.Vector2;

public class Enemy {

	private Vector2 position;
	private Vector2 velocity;
	
	public Enemy(float x, float y, float v) {
		position = new Vector2(x, y);
		velocity = new Vector2(0, v);
	}
	
	public void update(float delta) {
		
		// Move enemy
		position.add(velocity.cpy().scl(delta));
	}
	
	// Getters
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
}
