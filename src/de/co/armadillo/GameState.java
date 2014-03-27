package de.co.armadillo;

public class GameState {

	private int hitpoints;
	private int stage;
	private int score;
	
	public GameState(int hitpoints) {
		this.hitpoints = hitpoints;
		score = 0;
		stage = 1;
	}
	
	public void nextStage() {
		stage++;
	}
	
	public void addScore(int points) {
		score += points;
	}
	
	public void loseHealth() {
		hitpoints--;
	}
	
	public int getHitpoints() {
		return hitpoints;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getStage() {
		return stage;
	}
}
