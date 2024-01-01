package poker;

public abstract class Evaluator {
    public final int HAND_SIZE = 5;
	abstract public boolean evaluate(Card[] hand);
	abstract public void info();
	
    /**
     * Find joker in the hand
     * 
	 * @return boolean
     * @param Card[] hand
     */
	public boolean existJoker(Card[] hand)
	{
        if(hand[0].getValue()==0){
                return true;
        }
		return false;
	}
	
	/**
     * Checks for flush
     * 
	 * @return boolean
     * @param Card[] hand
     */
	public boolean flush(Card[] hand)
	{
        if(existJoker(hand)){
            for (int counter = 2; counter < HAND_SIZE; counter++)
		        {
			if (hand[1].getSuit() != hand[counter].getSuit())
			{
				return false;
			}
		}
		    return true;
        }else{
            for (int counter = 1; counter < HAND_SIZE; counter++)
            {
                if (hand[0].getSuit() != hand[counter].getSuit())
                {
                    return false;
                }
            }
            return true;
        }
		
	}
	
	/**
     * Checks for straight
     * 
	 * @return boolean
     * @param Card[] hand
     */
	public boolean straight(Card[] hand)
	{
        int chance=0;
        if(existJoker(hand)){
            chance=1;
        }
		for (int counter2 = 1; counter2 < HAND_SIZE; counter2++)
		{
			if (hand[counter2 - 1].getValue() != (hand[counter2].getValue() - 1) )
			{
                if(chance > 0) chance--;
				else return false;
			}
				
		}
		return true;
	}
}