package de.co.armadillo;

import com.badlogic.gdx.math.Vector2;

public class Target {

	private Vector2 start;
	private Vector2 end;
	
	public Target() {
		start = new Vector2(335, 725); // Position of our cannon
		end = new Vector2(335, 725);
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
