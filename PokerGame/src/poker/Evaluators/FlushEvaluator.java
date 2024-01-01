package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class FlushEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand) {
		return flush(hand);
	}
	
	public void info() {
		System.out.println("You have a flush");
	}
}
