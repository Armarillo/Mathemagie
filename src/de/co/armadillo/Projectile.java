package de.co.armadillo;

import com.badlogic.gdx.math.Vector2;

public class Projectile {

	private Vector2 position;
	private Vector2 velocity;
	private Target target;
	
	public Projectile(Target target) {
		position = new Vector2(335, 725);
		velocity = new Vector2(0, 0);
		this.target = target; 
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
		System.out.println(target.getAngle());
	}
	
	public void shoot(Enemy enemy) {
		
		System.out.println("SHOT IS DONE");
		velocity.x = 355;
		velocity.y = 725;
		velocity.setAngle(target.getAngle()-90);
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
}
