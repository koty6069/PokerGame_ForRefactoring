package poker;

import java.util.Random;

public class DeckDealer {
    private final int DECK_SIZE = 52;
    private final int SHUFFLE_EXCHANGES = 2000;
    private final int HAND_SIZE = 5;
	public int restOfDeck = 10;
	
	Card[] deck = new Card[DECK_SIZE];
	Random r = new Random();

    /**
     * Fill deck with various cards
     * 
     */
    public void fillDeck(boolean hasJoker)
	{
    	if(hasJoker)
    	{
    		deck = new Card[DECK_SIZE + 2];
    	}
    	
		int counter = 0;
		for (int suit = 1; suit <= 4; suit++)
		{
			for (int value = 1; value <= 13; value++)
			{
				deck[counter] = new Card(suit, value);
				counter++;
			}
		}
		
		if(hasJoker) 
		{
	        for(int counterJ=0; counterJ < 2; counterJ++){
	            deck[counter]=new Card(0,0);
	            counter++;
	        }
		}
		
		this.shuffle(hasJoker);
	}

    /**
     * Shuffle deck
     * 
     */
    public void shuffle(boolean hasJoker)
	{
    	int offset = 0;
    	if(hasJoker)
    	{
    		offset = 2;
    	}
		for (int x = 0; x <= SHUFFLE_EXCHANGES; x++)
		{
			int number1 = r.nextInt(DECK_SIZE + offset);
			int number2 = r.nextInt(DECK_SIZE + offset);
			Card temp = deck[number1];
			deck[number1] = deck[number2];
			deck[number2] = temp;
		}
    }

    /**
     * Create a full hand dealing cards of the deck.
     * 
     */
    public Card[] deal()
	{
		Card[] hand = new Card[HAND_SIZE];
		for (int deckPosition = 0; deckPosition < HAND_SIZE; deckPosition++)
		{
			hand[deckPosition] = this.deck[deckPosition];
            for(int counter=deckPosition; counter < this.deck.length-1; counter++){//Remove first card of the deck
                this.deck[counter]=this.deck[counter+1];
            }
		}
		return hand;
	}

    // deals cards for redraw
	public Card redeal()
	{
		Card nextCard = deck[restOfDeck];
		restOfDeck++;
		return nextCard;
	}
	
	// refreshes deck position to 6 for next hand
	public void refreshDeckPosition()
	{
		restOfDeck = 10;
	}

    public void setDeck(Card[] deck){
        this.deck=deck;
    }

    public Card[] getCards()
    {
        return this.deck;
    }

}
