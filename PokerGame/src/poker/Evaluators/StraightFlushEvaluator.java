package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class StraightFlushEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
		if(!this.flush(hand)) return false;
		if(!this.straight(hand)) return false;
		return true;
	}
	
	public void info() {
		System.out.println("You have a straight flush!");
	}
}
