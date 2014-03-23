package de.co.armadillo;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Projectile {

	private Vector2 position;
	private Vector2 velocity;
	private Circle circle;
	private Target target;
	
	
	public Projectile(Target target) {
		position = new Vector2(335, 725);
		velocity = new Vector2(0, 0);
		circle = new Circle(0, 0, 3);
		this.target = target; 
	}
	
	public void update(float delta) {
		position.add(velocity.cpy().scl(delta));
	}
	
	public void shoot(Enemy enemy) {
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
	
	public Circle getCircle() {
		return circle;
	}
	
}
