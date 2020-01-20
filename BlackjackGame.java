package coe318.lab5;
/*
 *@author: Serena Alli
 *Student id: 500844318
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BlackjackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }
  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }
  public void play() {
    while (!houseDone || !playerDone) {
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
      if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
      
    }
  }
  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }
  /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
  public int score(CardPile p) {
    Card c; 
    int sc = 0;//Score tracking varible
    int i = 0;//Used to check the size of the pile of cards to be scored.
    int temp;//Temporary varible to keep track of card values.
    /*Checks if the pile is not empty. 
    *(IMPORTANT Note to self: Even though p is a CardPile object of Arraylist, MUST use Arraylist method getCards() inorder to use Arraylist commands)
    *Previous condition statment: !(p.getCards().isEmpty()). is Valid, however cna no longer be used with current code.
    */
    while(i<(p.getCards().size()))
    {
        /*Referencing p's array list: If we used the method from start with c = p.removeRandom();, 
        *would also remove card from the orginal deck, regardless of a new pile varbile being made to be removed.
        *Example: CardPile new = p; //Set new = p.
        *         c = new.removeRandom();//Would remove card from p, therefore; removed a card from the oringial pile.
        */
        c = p.getCards().get(i);
        temp = c.getRank();
        switch (temp){
            case 11://Checks for Jack
                sc += 10;
                break;
            case 12://Checks for Queen
                sc += 10;
                break;
            case 13://Checks for King
                sc += 10;
                break;
            case 14://Checks for Ace, returns 1 (for simplicity)
                sc += 1;
                break;
            default://Adds numbers 2-10
                sc += temp;
                break;
        } 
        i++;
    }    
    return sc;
  }
  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }
  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }
  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}