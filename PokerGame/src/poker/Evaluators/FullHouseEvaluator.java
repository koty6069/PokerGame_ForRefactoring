package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class FullHouseEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
		int comparison = 0;
		for (int counter = 1; counter < HAND_SIZE; counter++)
		{
			if (hand[counter - 1].getValue() == hand[counter].getValue())
			{
				comparison++;
			}
            else if(existJoker(hand)){
                comparison++;
            }
		}
		if (comparison == 3)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void info() {
		System.out.println("You have a full house!");
	}
}
