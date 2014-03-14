package de.co.armadillo;

import com.badlogic.gdx.math.Rectangle;

public class GameCharacter {

	private Rectangle rect;
	private Rectangle cannon;
	
	private float rotation;
	
	public GameCharacter(float x, float y) {
		rect = new Rectangle(x, y, 50, 50);
		cannon = new Rectangle(x+20, y-20, 10, 20);
		rotation = 0;
	}
	
	public void update() {
		rotation++;
		
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public Rectangle getCannon() {
		return cannon;
	}
}
