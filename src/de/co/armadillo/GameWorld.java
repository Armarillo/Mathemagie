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
	private Enemy enemy;
	private Background background;
	private GameCharacter character;
	private Stage stage;
	private TextField tf;
	
	// Amount of enemies
	//private int amount = 1;
	
	public GameWorld() {
		
		r = new Random();
		target = new Target();
		background = new Background(0, 0, 10);
		character = new GameCharacter(310, 700, target);
		enemy = new Enemy(r.nextInt(720), -r.nextInt(400), 50 + r.nextInt(50));
		
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
		tf.setCursorPosition(5);
		tf.setTextFieldListener(new TextFieldListener() {
			
			public void keyTyped (TextField textField, char key) {

				// Check if input matches answer of equation
				try {
					if(enemy.getEquation().checkAnswer(Integer.valueOf(tf.getText())))
						tf.setText("");
					else if(key == '\n' || key == '\r')
						tf.setText("");
				}catch(Exception ex) {}
			}
		});
		stage.addActor(tf);
	}
	
	// Responsible for updating variables, controlling the game state
	public void update(float delta) {
		
		// Update background
		background.update(delta);
		
		// Update enemy	
		enemy.update(delta);
		
		// Update aiming
		target.update(enemy); // TODO: Switching enemies
	}

	public GameCharacter getChar() {
		return character;
	}
	
	public Enemy getEnemy() {
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
}
