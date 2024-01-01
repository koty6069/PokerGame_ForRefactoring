package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class PairEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
        if(existJoker(hand)){
            return true;
        }
		int check = 0;
		for(int counter = 1; counter < HAND_SIZE; counter++)
		{
			if (hand[counter - 1].getValue() == hand[counter].getValue())
			{
				check++;
			}
		}
		if (check == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void info() {
		System.out.println("You have a pair!");
	}
}
