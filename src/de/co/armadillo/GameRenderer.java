package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

	// Instance of World to render
	private GameWorld world;
	private GameWindow window;
	private OrthographicCamera cam;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		
		// Create cam
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
	}

	// Responsible for general rendering of the game world
	public void render(float delta) {
		
		// Clear board
		Gdx.gl.glClearColor(255/255.0f, 165/255.0f, 0/255.0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		window.batch.begin();
		
		// Draw background
		window.batch.draw(AssetLoader.bg, world.getBackground().getX(), world.getBackground().getY());
		window.batch.draw(AssetLoader.bg, world.getBackground().getX(), world.getBackground().getY()-840);
		
		// Draw cross
		window.batch.draw(AssetLoader.cross, 
				world.getEnemy().getX()-35, 
				world.getEnemy().getY()-35, 
				35, 
				35, 
				70, 
				70,  	
				2, 
				2, 
				world.getTarget().getSpin());
		
		// Draw equation
		AssetLoader.font.draw(window.batch, 
				world.getEnemy().getEquation().getQuestion(), 
				world.getEnemy().getX()-22, world.getEnemy().getY()-5);
		
		window.batch.end();
		
		// Draw stage
		world.getStage().act(delta);
		world.getStage().draw();
		
		window.shape.begin(ShapeType.Line);
		
		// Set color
		window.shape.setColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
		
		// Draw enemy
		window.shape.circle(world.getEnemy().getX(), 
				world.getEnemy().getY(), 
				40);
		
		// Draw projectile
		window.shape.circle(world.getProjectile().getX(), 
				world.getProjectile().getY(), 
				3);
		
		// Draw character
		window.shape.rect(world.getChar().getRect().x, 
				world.getChar().getRect().y, 
				world.getChar().getRect().width, 
				world.getChar().getRect().height, 
				25, 
				25, 
				world.getChar().getRotation());
		
		// Draw its cannon
		window.shape.rect(world.getChar().getCannon().x, 
				world.getChar().getCannon().y, 
				world.getChar().getCannon().width, 
				world.getChar().getCannon().height, 
				5, 
				45, 
				world.getChar().getRotation());
		
		// Mark enemy red
		window.shape.setColor(255/255.0f, 0/255.0f, 0/255.0f, 1);
		
		window.shape.circle(world.getTarget().getEnd().x, 
				world.getTarget().getEnd().y, 
				40);
		
		window.shape.end();
	}

}
