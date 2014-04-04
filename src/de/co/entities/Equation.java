package de.co.armadillo.entities;

import java.util.Random;

public abstract class Equation {

	public String question;
	public double answer;
	public Random r;
	
	public Equation() {
		
		r = new Random();
		question = setQuestion();
	}
	
	abstract public String setQuestion();
	
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
