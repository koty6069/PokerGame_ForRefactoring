package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class FiveKindEvaluator extends Evaluator {
	public boolean evaluate(Card[] hand)
	{
        for(int counter2=2;counter2<HAND_SIZE;counter2++){
            if(existJoker(hand) && hand[counter2-1] != hand[counter2] ){
                return false;
            }
        }
        return true;
	}
}
