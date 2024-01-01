package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class TripleEvaluator extends Evaluator{
	public boolean evaluate(Card[] hand)
	{
        if(existJoker(hand)){//And a pair is triple
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
		else
		{
			
            for(int counter = 0; counter < HAND_SIZE; counter++)
            {
                int check = 0;
                int card=hand[counter].getValue();
                for(int counter2=counter+1; counter2 <HAND_SIZE; counter2++){
                    if(hand[counter2].getValue()==card){
                        check++;
                    }
                }
                if (check == 2)
                {
                    return true;
                }
            }
            return false;
		}
	}
	
	public void info() {
		System.out.println("You have a triple!");
	}
}
