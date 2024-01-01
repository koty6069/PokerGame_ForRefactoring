package poker;

import java.util.Arrays;

public class Player {
    
    private int chips;

    private PlayerAction action;

    private Card[] hand;

    public Player(int chips){
        this.chips=chips;
        this.hand=null;
    }

    /**
     * Player bet the chips
     * 
     * @param integer $chips
     * @return integer
     */
    public int bet(int chips){
        this.chips -= chips;
        this.action = PlayerAction.BET;
        return chips;
    }

    /**
     * Player raise last bet (no creo que haga falta)
     * 
     * @param integer $chips
     * @return integer
     */
    public int raise(int chips){
        this.chips -= chips;
        this.action = PlayerAction.RAISE;
        return chips;
    }

    /**
     * Player pass without raise
     * 
     */
    public void check(){
        this.action = PlayerAction.CHECK;
    }

    /**
     * Player withdraws from this turn
     * 
     */
    public void hold(){
        this.action = PlayerAction.HOLD;
    }


    /**
     * Returns the chips of this player
     * 
     * @return integer
     */
    public int getChips(){
        return this.chips;
    }
    /**
     * Returns the hand of this player
     * 
     * @return Card[]
     */
    public Card[] getHand(){
        return this.hand;
    }
    /**
     * Set the chips of this player
     * 
     * @param integer $chips
     */
    public void setChips(int chips){
        this.chips = chips;
    }
    /**
     * Set the hand of this player
     * 
     * @param Card[] $hand
     */
    public void setHand(Card[] hand){
    	Arrays.sort(hand);
        this.hand = hand;
    }

    /**
     * Returns the action done by this player
     * 
     * @return Card[]
     */
    public PlayerAction getAction(){
        return this.action;
    }
    /**
     * Set new action will do this player
     * 
     * @param integer $chips
     */
    public void setAction(PlayerAction action){
        this.action = action;
    }

    /**
     * switches card for a new card
     * 
     * @param integer $chips
     */
	public Card redraw(int counter, DeckDealer deck)
	{
		Card card = deck.redeal();
		return card;
	}

    
}
