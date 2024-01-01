package poker;

import java.util.Scanner;
import java.util.Arrays;

public class Game {

    // instantiates
	final int HAND_SIZE = 5;
    boolean hasJoker = false;
    int chipsPlayer=1;
	Scanner scan = new Scanner(System.in);
    
    HandlerHandJoker handlerJK= new HandlerHandJoker();

	DeckDealer deck = new DeckDealer();
	Player player = new Player(chipsPlayer);
    Player crupier = new Player(chipsPlayer);
   

    public void play() throws InterruptedException
	{
        char c = 'f';
        do{//Jokers or without jokers
            System.out.print("Would you like to play with 2 jokers?(Y/N): ");
            c = Character.toUpperCase(scan.next().charAt(0));
        }while (c != 'N' && c != 'Y');
        if(c == 'Y')
        {
        	hasJoker = true;
        }
        
        do{//Amount of chips
            System.out.print("How many chips would you like to play?: ");
            chipsPlayer = scan.nextInt();
        }while (chipsPlayer<0);
        
        player.setChips(chipsPlayer);
        crupier.setChips(chipsPlayer);

/*Card[] array=this.deck.getCards();
for(int i=0;i<this.deck.getCards().length;i++){
    System.out.println(array[i].getValue()+ " // " + array[i].getSuit());
}*/
        while (player.getChips() > 0 && crupier.getChips() >0)
        {
        	System.out.println();
            System.out.println("NEW TURN!");
            System.out.println();
        	//Fill deck
        	deck.fillDeck(hasJoker);
        	//Start game
        	this.startGame();
        }

        if(this.player.getChips()==0) 
        	System.out.println("THE WINNER IS CRUPIER!!");
        else
        	System.out.println("YOU ARE THE WINNER!!");
	}
    
    public void printChipResult(int player, int crupier) {
        System.out.println("**********************************************");
        System.out.println("Player's chips: "+ player);
        System.out.println("Crupier's chips: "+ crupier);
        System.out.println("**********************************************");
    }
    
    public void printHandResult(Player player, Player crupier) {
        System.out.println("SHOW CARDS...\n");
        // evaluate the hand
        System.out.print("Player: ");
        handlerJK.evaluate(player.getHand());
        System.out.print("Crupier: ");
        handlerJK.evaluate(crupier.getHand());
    }

    public void startGame() throws InterruptedException{
        int pot = 0;
        System.out.println("SHUFFLING...\n");
        Thread.sleep(1000);
            
        //players draws
        player.setHand(deck.deal());
        crupier.setHand(deck.deal());
            
        //Look our cards
        System.out.print("PLAYER'S ");
        int playerHand = handlerJK.checkHand(player.getHand());

        //Redraw new cards
        System.out.print("Would you like to change some your cards?(1 for yes, 0 for no): ");
        int redrawans = scan.nextInt();
        if(redrawans >= 1){
            this.redraw(this.player.getHand());
            Arrays.sort(player.getHand());
            System.out.print("NEW ");
            playerHand = handlerJK.checkHand(player.getHand());
        }

        int answerBet = 0;
        do{
            //BET, CHECK OR HOLD
            System.out.print("Would you like to bet (2), to check (1) or to hold (0)?: ");
            answerBet = scan.nextInt();
        }while(answerBet < 0 && answerBet > 2);

        if(answerBet > 0){
            boolean chipCorrect = true;
            if(answerBet == 1) chipCorrect = false;
                
            while(chipCorrect){
                System.out.print("How many chips would you like to bet? ");
                int chips = scan.nextInt();
                    
                if(chips <=0 || chips > player.getChips() || chips > crupier.getChips()){
                    System.out.println("The amount entered is less than 0 or more than your token limit("+player.getChips()+ "/" +crupier.getChips()+"). Please try again");
                }else{
                    player.bet(chips);
                    crupier.bet(chips);
                    pot = chips * 2;
                    chipCorrect = false;
                }
            }
            
            // display crupier hand
            Thread.sleep(1000);
            System.out.println();
            System.out.print("CRUPIER'S ");
            int crupierHand = handlerJK.checkHand(crupier.getHand());
            Thread.sleep(1000);
            
            this.printHandResult(player, crupier);
            Thread.sleep(1000);
            this.checkBet(playerHand, crupierHand, pot);
            this.printChipResult(player.getChips(), crupier.getChips());
        }
        else if (answerBet == 0){
            winChips(crupier,pot);
        }
    }

    /**
     * Set chips for the winner
     * 
     * @param Player player 
     * @param int pot
     */
    public void winChips(Player p, int pot){
        int chipCounter = p.getChips();
        p.setChips(chipCounter + pot);
    }

    /**
     * Get the evaluation and give the chips for the winner
     * 
     * @param int player evaluation hand
     * @param int crupier evaluation hand
     * @param int pot
     */
    public void checkBet(int player, int crupier, int pot){
        if(player != crupier){
            winChips(this.player,pot);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            
            if(player > crupier)
            	System.out.println("                YOU WIN");
            else
            	System.out.println("              CRUPIER WIN");
            
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else{
            if(player==1){ //Double highCard
                //Get the each highCard
                int highCardPlayer = handlerJK.highCard(this.player.getHand());
                int highCardCrupier = handlerJK.highCard(this.crupier.getHand());

                if(highCardPlayer==1) highCardPlayer=14; //High card is ace
                if(highCardCrupier==1) highCardCrupier=14;

                checkBet(highCardPlayer,highCardCrupier,pot);
            }else if(player==2){ //Double pair
                int valuePairPlayer = 0;
                int valuePairCrupier = 0;
                for(int counter = 1; counter < HAND_SIZE; counter++)
                {
                    if(handlerJK.existJoker(this.player.getHand())){//JokerHands
                        valuePairPlayer= handlerJK.highCard(this.player.getHand());
                    }
                    if(handlerJK.existJoker(this.crupier.getHand())){//JokerHands
                        valuePairCrupier= handlerJK.highCard(this.crupier.getHand());
                    }
                    if (this.player.getHand()[counter - 1].getValue() == this.player.getHand()[counter].getValue())
                    {
                        valuePairPlayer=this.player.getHand()[counter - 1].getValue();
                    }
                    if (this.crupier.getHand()[counter - 1].getValue() == this.crupier.getHand()[counter].getValue())
                    {
                        valuePairCrupier=this.crupier.getHand()[counter - 1].getValue();
                    }
                    if(valuePairPlayer==1) valuePairPlayer=14; //High pair is double ace
                    if(valuePairCrupier==1) valuePairCrupier=14;//High pair is double ace
                }
                checkBet(valuePairPlayer,valuePairCrupier,pot);
            }else{//Same cards, Nobody win
                winChips(this.crupier,pot/2);
                winChips(this.player,pot/2);
            }
            
        } 
    }

     /**
     * Asks if player wants to redraw
     * 
     * @param Card[] player hand
     */
	public Card[] redraw(Card[] hand)
	{
		for (int counter = 0; counter < HAND_SIZE; counter++)
		{
			System.out.print("Card " + (counter + 1) + "?" +
					" (1 for yes, 0 for no): ");
			int answer = scan.nextInt();
			if (answer == 1)
			{
				hand[counter] = player.redraw(counter, deck);
			}
		}
		deck.refreshDeckPosition();
		return hand;
	}

}
