
/**
 *
 * @author Serena Alli
 * Student id: 500844318
 */
package coe318.lab5;
import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;
    int random; //intializing random varible
    public CardPile() {
        //Initialize the instance variable.
    cards = new ArrayList();//Creating cards Arraylist
    
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
      cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        Card temp;//Creating instance variable of Card object.
        random = (int)(Math.random()*(this.cards.size()+1));
        /*Cast random number into int, and multiplying the random decmial by 
         *the card array size plus 1, because int rounds numbers down, therefore. 0.9999*52 will equal 51. So we need 
         *0.9999*((52)+1) if we ever want to have 52 as a value, assuming 1.0 is not one of the Math.random() values.
         */
        if (random == 0)//If random is somehow 0, (unlikely) increases digit to 1.
        {
            random ++;
        }
        else if(random >this.cards.size())//If random is somehow size of array +1, decrease to make it into size of array.
        {
            random --;
        }
        /*
        *Checks if random is 0, therefore keeps making random values till
        *random is not zero. However, must also check if random is greater than cards array, for the chance 
        *Math.random() eqauls 1.0, making random equal (card.size()+1)
        */
        temp = this.cards.get(random-1);//Sets card c as the card in the arry at (random-1) because array reads from 0 to array size
        this.cards.remove(random-1);//Remove card the at the int random varible. Again, remove at (random-1)
        return temp;//Returns to output the card that was removed.
    }
    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        //FIX THIS
        return "" + getCards();//Using getCards() method, outputs all the cards in the CardPile in order of adding sequence.
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());
        }
    }


}
