package de.co.armadillo;

import com.badlogic.gdx.math.Vector2;

public class Aiming {

	private Vector2 start;
	private Vector2 end;
	
	public Aiming(float startX, float startY) {
		start = new Vector2(startX, startY);
		end = new Vector2(startX, startY);
	}

	public void update(Enemy enemy) {
		
		// Update end point to enemy movement
		end.x = enemy.getX();
		end.y = enemy.getY();
	}
	public float getAngle() {
		
		return end.cpy().sub(start).angle()+90;
		
	}
	public Vector2 getStart() {
		return start;
	}
	
	public Vector2 getEnd() {
		return end;
	}
}
