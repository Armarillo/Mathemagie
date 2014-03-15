package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

	// Instance of World to render
	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shape;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		
		// Create cam
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
	
		// Create object which is in charge of rendering the shapes
		shape = new ShapeRenderer();
		shape.setProjectionMatrix(cam.combined);
	}

	// Responsible for general rendering of the game world
	public void render() {
		
		// Clear board
		Gdx.gl.glClearColor(255/255.0f, 165/255.0f, 0/255.0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		shape.begin(ShapeType.Line);
		
		// Set color
		shape.setColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
		
		// Draw enemies
		for(int i = 0; i < world.getEnemy().length; i++) {
			shape.circle(world.getEnemy()[i].getX(), world.getEnemy()[i].getY(), 25);
		}
		
		// Draw character
		shape.rect(world.getChar().getRect().x, 
				world.getChar().getRect().y, 
				world.getChar().getRect().width, 
				world.getChar().getRect().height, 
				25, 
				25, 
				world.getChar().getRotation());
		
		// Draw its cannon
		shape.rect(world.getChar().getCannon().x, 
				world.getChar().getCannon().y, 
				world.getChar().getCannon().width, 
				world.getChar().getCannon().height, 
				5, 
				45, 
				world.getChar().getRotation());
		
		// Draw aiming help TODO: Draw dotted line
		shape.line(world.getAim().getStart(), 
				world.getAim().getEnd());
		
		shape.end();
		
	}

}
