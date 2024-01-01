package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class StraightEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand) {
		return straight(hand);
	}
	
	public void info() {
		System.out.println("You have a straight!");
	}
}
