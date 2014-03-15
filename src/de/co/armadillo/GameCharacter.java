package de.co.armadillo;

import com.badlogic.gdx.math.Rectangle;

public class GameCharacter {

	private Rectangle rect;
	private Rectangle cannon;
	
	private Aiming aim;
	
	public GameCharacter(float x, float y, Aiming aim) {
		
		this.aim = aim;
		
		rect = new Rectangle(x, y, 50, 50);
		cannon = new Rectangle(x+20, y-20, 10, 20);
	}
	
	public float getRotation() {
		return aim.getAngle();
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public Rectangle getCannon() {
		return cannon;
	}
}
