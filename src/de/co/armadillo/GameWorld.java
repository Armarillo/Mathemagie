package de.co.armadillo;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;

public class GameWorld {

	private Random r;
	private Target target;
	private Enemy[] enemy;
	private Background background;
	private GameCharacter character;
	private Stage stage;
	private TextField tf;
	private Projectile fire;
	
	// Amount of enemies
	private int amount = 2;
	
	// Target index
	private int targetNumb;
	
	public GameWorld() {
		
		r = new Random();
		
		// Background object necessary for scrolling
		background = new Background(0, 0, 10);
		
		// Initialize array
		enemy = new Enemy[amount];
		
		// Initialize enemies
		for(int i = 0; i < enemy.length; i++) {
			enemy[i] = new Enemy(r.nextInt(720), -r.nextInt(400), 50 + r.nextInt(50));
		}
		
		// Choose target for enemy
		target = new Target();
		targetNumb = r.nextInt(amount);
		
		// Create Cannon, targeting the target
		character = new GameCharacter(310, 700, target);
		
		// Projectile which is destined to hit specific target
		fire = new Projectile(target);
		
		// Create Stage
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		// Skin for UI Elements
		Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		// Initialize Textfield
		tf = new TextField("", skin);
		tf.setPosition(265, 25);
		tf.setSize(150, 50);
		tf.setMaxLength(9);
		stage.setKeyboardFocus(tf);
		tf.setTextFieldListener(new TextFieldListener() {
			
			public void keyTyped (TextField textField, char key) {

				// Check if input matches answer of equation
				try {
					if(enemy[targetNumb].getEquation().checkAnswer(Integer.valueOf(tf.getText()))) {
						tf.setText("");
						fire.shoot(enemy[targetNumb]);
					}else if(key == '\n' || key == '\r') {
						tf.setText("");
					}
				}catch(Exception ex) {}
			}
		});
		stage.addActor(tf);
	}
	
	// Responsible for updating variables, controlling the game state
	public void update(float delta) {
		
		// Update background
		background.update(delta);
		
		// Update every enemy	
		for(int i = 0; i < enemy.length; i++) {
			enemy[i].update(delta);
		}
		
		// Update projectile
		fire.update(delta);
		
		// Update aiming
		target.update(enemy[targetNumb]); // TODO: Switching enemies
		
		// Check if projectile hit enemy
		if(fire.checkCollision(enemy[targetNumb].getCircle())) {
			enemy[targetNumb].gotHit();
			enemy[targetNumb].destroy();
		}
	}

	public GameCharacter getChar() {
		return character;
	}
	
	public Enemy[] getEnemy() {
		return enemy;
	}
	
	public Target getAim() {
		return target;
	}

	public Background getBackground() {
		return background;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public Projectile getProjectile() {
		return fire;
	}
	
	public Target getTarget() {
		return target;
	}
	
	public int getTargetNumb() {
		return targetNumb;
	}
}
