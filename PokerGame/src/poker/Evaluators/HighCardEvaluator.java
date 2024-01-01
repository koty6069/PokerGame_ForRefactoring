package poker.Evaluators;

import poker.Card;
import poker.Evaluator;

public class HighCardEvaluator extends Evaluator {
	private int highCard = 0;
	public boolean evaluate(Card[] hand)
	{
		for (int counter = 0; counter < HAND_SIZE; counter++)
		{
			if (hand[counter].getValue() > highCard)
			{
				highCard = hand[counter].getValue();
			}
		}
		return true;
	}
	
	public void info() {
		if(highCard==1) System.out.println("Your highest card is Ace");
		else if(highCard==11) System.out.println("Your highest card is Jack");
		else if(highCard==12) System.out.println("Your highest card is Queen");
		else if(highCard==13) System.out.println("Your highest card is King");
		else System.out.println("Your highest card is " + highCard);
	}
	
	public int getHighCard(Card[] hand) {
		this.evaluate(hand);
		return this.highCard;
	}
}
