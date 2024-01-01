package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class TwoPairsEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
		int check = 0;
		for(int counter = 1; counter < HAND_SIZE; counter++)
		{
			if (hand[counter - 1].getValue() == hand[counter].getValue())
			{
				check++;
			}
		}
		if (check == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void info() {
		System.out.println("You have a two pairs!");
	}
}
