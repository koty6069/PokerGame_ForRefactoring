package poker;

import java.util.ArrayList;
import poker.Evaluators.*;

public class HandlerHandJoker {
    private final int HAND_SIZE = 5;
    private final int EVALUATE_SIZE = 10;
    ArrayList<Evaluator> evaluator = new ArrayList();
    
    public void setEvaluator() {
    	evaluator.add(new HighCardEvaluator());
    	evaluator.add(new PairEvaluator());
    	evaluator.add(new TwoPairsEvaluator());
    	evaluator.add(new TripleEvaluator());
    	evaluator.add(new StraightEvaluator());
    	evaluator.add(new FlushEvaluator());
    	evaluator.add(new FullHouseEvaluator());
    	evaluator.add(new FourOfaKindEvaluator());
    	evaluator.add(new StraightEvaluator());
    	evaluator.add(new RoyalFlushEvaluator());
    }

	/**
     * Evaluates the hand
     * 
	 * @return int
     * @param Card[] hand
     */
	public int evaluate(Card[] hand)
	{
        int evaluation = 0;
		for(int i = EVALUATE_SIZE - 1; i >= 0; i--) {
			if(this.evaluator.get(i).evaluate(hand)) {
				this.evaluator.get(i).info();
				evaluation = i + 1;
				break;
			}
		}
        return evaluation;
	}

	/**
     * Tells player cards in hand
     * 
     * @param Card[] hand
     */
	public int checkHand(Card[] hand)
	{
        System.out.println(" CARDS:");
		for (int handCounter = 0; handCounter < HAND_SIZE; handCounter++)
		{
			this.display(hand[handCounter]);
		}
        System.out.println();
        int playerHand = this.evaluate(hand);
        System.out.println();
        return playerHand;
	}
	
	public void printSuit(int suit)
	{
		switch(suit) {
		case 1:
			System.out.print(" Spades |");
			break;
		case 2:
			System.out.print(" Hearts |");
			break;
		case 3:
			System.out.print("Diamonds|");
			break;
		case 4:
			System.out.print("  Clubs |");
			break;
		default:
			System.out.print("  No suit |");
			break;
		}
		System.out.println();
	}

	public void display(Card card)
	{
		int v = card.getValue();
		switch(v) {
		case 0:
			System.out.println("|     JOKER      |");
			break;
		case 10:
			System.out.print("| 10  of ");
			break;
		case 11:
			System.out.print("| J   of ");
			break;
		case 12:
			System.out.print("| Q   of ");
			break;
		case 13:
			System.out.print("| K   of ");
			break;
		default:
			System.out.print("| " + v + "   of ");
			break;
		}
		this.printSuit(card.getSuit());
	}
}




