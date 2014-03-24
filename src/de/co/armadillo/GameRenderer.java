package de.co.armadillo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

	// Instance of World to render
	private GameWorld world;

	private SpriteBatch batch;
	private ShapeRenderer shape;
	
	private OrthographicCamera cam;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		
		// Create cam
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		shape = new ShapeRenderer();
		shape.setProjectionMatrix(cam.combined);
	}

	// Responsible for general rendering of the game world
	public void render(float delta) {
		
		// Clear board
		Gdx.gl.glClearColor(255/255.0f, 165/255.0f, 0/255.0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		// Draw background
		batch.draw(AssetLoader.bg, world.getBackground().getX(), world.getBackground().getY());
		batch.draw(AssetLoader.bg, world.getBackground().getX(), world.getBackground().getY()-840);
		
		// Draw cross
		batch.draw(AssetLoader.cross, 
				world.getEnemy().getCircle().x-35, 
				world.getEnemy().getCircle().y-35, 
				35, 
				35, 
				70, 
				70,  	
				2, 
				2, 
				world.getTarget().getSpin());
		
		// Draw equation
		AssetLoader.font.draw(batch, 
				world.getEnemy().getEquation().getQuestion(), 
				world.getEnemy().getCircle().x-22, world.getEnemy().getCircle().y-5);
		
		batch.end();
		
		// Draw stage
		world.getStage().act(delta);
		world.getStage().draw();
		
		shape.begin(ShapeType.Line);
		
		// Set color
		shape.setColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
		
		// Draw enemy
		shape.circle(world.getEnemy().getCircle().x, 
				world.getEnemy().getCircle().y, 
				world.getEnemy().getCircle().radius);
		
		// Draw projectile
		shape.circle(world.getProjectile().getCircle().x, 
				world.getProjectile().getCircle().y, 
				world.getProjectile().getCircle().radius);
		
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
		
		// Mark enemy red
		shape.setColor(255/255.0f, 0/255.0f, 0/255.0f, 1);
		
		shape.circle(world.getTarget().getEnd().x, 
				world.getTarget().getEnd().y, 
				40);
		
		shape.end();
	}

}
