package de.co.armadillo;

import java.util.Random;

public class Equation {

	private String question;
	private double answer;
	private Random r;
	
	/**
	 * @param difficulty number between 0 (easiest) to 2 (hardest)
	 */
	public Equation(int difficulty) {
		
		r = new Random();
		question = setQuestion(difficulty);
	}
	
	private String setQuestion(int difficulty) {
		if(difficulty == 0) {
			
			// Get number between 0 - 100
			int a = r.nextInt(100);
			int b = r.nextInt(100);
			
			answer = a+b;
			return a + " + " + b;
			
		}else if(difficulty == 1) {
			
			// Get number between 0 - 100
			double a = 100 * r.nextDouble();
			double b = 100 * r.nextDouble();
			
			// Round to 2 decimals
			a = Math.round(a*100)/100.0;
			b = Math.round(b*100)/100.0;
			
			answer = a+b;
			return a + " + " + b;
			
		}else if(difficulty == 2) {
		
			// Get number between 100 - 1000
			double a = 100 + 900 * r.nextDouble();
			double b = 100 + 900 * r.nextDouble();
			
			// Round to 3 decimals
			a = Math.round(a*1000)/1000.0;
			b = Math.round(b*1000)/1000.0;
			
			answer = a+b;
			return a + " + " + b;
	
		}else{
			System.out.println("ERROR");
			return null;
		}
	}
	
	public String getQuestion() {
		return question;
	}
	
	public double getAnswer() {
		return answer;
	}
	
	public boolean checkAnswer(int answer) {
		if(answer == this.answer)
			return true;
		else
			return false;
	}
}
