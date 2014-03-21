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
	private OrthographicCamera cam;
	private ShapeRenderer shape;
	private SpriteBatch batch;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		
		// Create cam
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
	
		// Create object which is in charge of rendering the shapes
		shape = new ShapeRenderer();
		shape.setProjectionMatrix(cam.combined);
		
		// Create object which is in charge of rendering sprites/fonts
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
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
		
		// Draw equation
		AssetLoader.font.draw(batch, world.getEnemy().getEquation().getQuestion(), world.getEnemy().getX()-22, world.getEnemy().getY()-5);
		
		batch.end();
		
		// Draw stage
		world.getStage().act(delta);
		world.getStage().draw();
		
		shape.begin(ShapeType.Line);
		
		// Set color
		shape.setColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
		
		// Draw enemy
		shape.circle(world.getEnemy().getX(), world.getEnemy().getY(), 40);
		
		// Draw projectile
		shape.circle(world.getProjectile().getX(), world.getProjectile().getY(), 3);
		
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
		
		// Draw text field
		
		shape.end();
	}

}
