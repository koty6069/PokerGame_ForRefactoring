package poker;

public class Card implements Comparable<Card>{
    private int suit;
    private int value;

    public Card(int suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public String getDescription(){
        return this.value+ " of " + this.suit;
    }

    public int getSuit(){
        return suit;
    }

    public int getValue(){
        return value;
    }

    public void setSuit(int suit){
        this.suit = suit;
    }

    public void setValue(int value){
        this.value=value;
    }

    public int[] getCard(){
        int[] card= {this.value,this.suit};
        return card;
    }

    public int compareTo(Card compareCard) {
	
		int compareQuantity = compareCard.getValue(); 
		
		//ascending order
		return this.value - compareQuantity;
		
		//descending order
		//return compareQuantity - this.quantity;
		
	}
}
