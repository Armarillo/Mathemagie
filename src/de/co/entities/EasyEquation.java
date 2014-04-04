package de.co.armadillo.entities;

public class EasyEquation extends Equation{
	
	public EasyEquation() {
		super();
	}
	
	@Override
	public String setQuestion() {
		
		int a, b;
		
		switch(r.nextInt(3)) {

		case 0:
			a = 1 + r.nextInt(100);
			b = 1 + r.nextInt(100);
				
			answer = a+b;
			return a + " + " + b;
		case 1:
			
			a = 1 + r.nextInt(100);
			b = 1 + r.nextInt(100);
			
			answer = a-b;
			return a + " - " + b;
		case 2:
			do {
				a = 1 + r.nextInt(20);
				b = 1 + r.nextInt(20);
				
				answer = a*b;
			}while(a > 10 && b > 10);
			return a + " x " + b;
		case 3:
			do {
				a = 1 + r.nextInt(100);
				b = 1 + r.nextInt(100);
				
				answer = a/b;
			}while(a%b != 0);
			return a + " x " + b;
		default:
			return "error";
		}
	}
}
