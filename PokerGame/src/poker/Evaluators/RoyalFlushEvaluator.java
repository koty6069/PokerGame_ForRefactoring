package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class RoyalFlushEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
		if (this.flush(hand) && (hand[0].getValue() == 1 || hand[0].getValue() == 0) && 
            (hand[1].getValue() == 10) &&
            (hand[2].getValue() == 11) &&
			(hand[3].getValue() == 12) &&
            (hand[4].getValue() == 13))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void info() {
		System.out.println("You have a royal flush!");
	}
}
