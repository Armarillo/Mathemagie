package de.co.armadillo;

import com.badlogic.gdx.math.Rectangle;

public class GameCharacter {

	private Rectangle rect;
	
	private float rotation;
	
	public GameCharacter(float x, float y) {
		rect = new Rectangle(x, y, 50, 50);
		rotation = 0;
	}
	
	public void update() {
		//rect.x++;
		rotation++;
		
		if(rect.x >= 720)
			rect.x = 0;
		
	}
	
	public float getRotation() {
		return rotation;
	}
	
	public Rectangle getRect() {
		return rect;
	}
}
