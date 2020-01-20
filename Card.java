/*
 *@Author: Serena Alli
 *Studen id: 500844318
 *
 */
package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  int rank, suit;
  boolean faceUp = false;
  
  public Card(int rank, int suit, boolean faceUp) {
    this.rank = rank;
    this.suit = suit;
    this.faceUp = faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
      if(this.faceUp == true)
      {
          return true;
      }
    return false;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return this.rank; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return this.suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    if(getRank()==c.getRank() && getSuit()==c.getSuit())
    {
        return true; 
    }
    return false;
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {//NOT SURE WHAT IT WANTS YET FIX LATER
      if(getRank()>=c.getRank())//Checks if intial card is greater/equal in rank
      {
          if(getSuit()>=c.getSuit())//Checks if intial card is greater/equal in suit
          {
              return getRank();
          }else
          {
              return c.getRank();//Returns the rank of the other card
          }
      }else
      {
          return c.getRank();// returns rank of the other card
      }
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      if(getRank()<=10 && getRank()>=2)//Checks if the inputed rank is a valid value
      {
        return Integer.toString(getRank());//Converts the rank of the card into a String
      }else if(getRank() == 11)
      {
          return "Jack";
      }else if(getRank() == 12)
      {
          return "Queen";
      }else if(getRank() == 13)
      {
          return "King";
      }else if(getRank() == 14)
      {
          return "Ace";
      }
      return "Error";//If rank is not within 2-14, outputs Error message.
      
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *                               0,      1,          2,           3
   * @return the suit String
   */
  public String getSuitString() {
    String type = "Error";//if the inputed suit is not within 2-14, outputs Error message.
      switch (getSuit()) {
          case CLUB:
              type = "Clubs";
              break;
          case DIAMOND:
              type = "Diamonds";
              break;
          case HEART:
              type = "Hearts";
              break;
          case SPADE:
              type = "Spades";
              break;
          default:
              break;
      }
      return type;
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    
    return (isFaceUp())?(getSuitString()+" "+getRankString()):"?";
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}