package de.co.armadillo;

public class GameState {

	public static int hitpoints = 3;
	public static int stage = 1;
	public static int score = 0;
	
	public void nextStage() {
		stage++;
	}
	
	public void addScore(int points) {
		score += points;
	}
	
	public void loseHealth() {
		hitpoints--;
	}
	
	public static boolean isGameOver() {
		if(hitpoints == 0)
			return true;
		else
			return false;
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
