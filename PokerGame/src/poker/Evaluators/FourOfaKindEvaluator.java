package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class FourOfaKindEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
		if ((hand[0].getValue() != hand[3].getValue() || hand[0].getValue() != 0) && hand[1].getValue() != hand[4].getValue())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void info() {
		System.out.println("You have four of a kind!");
	}
}
