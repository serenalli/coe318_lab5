/*
 *@Author: Serena Alli
 *Studen id: 500844318
 *
 */
package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    private String answer;
    /*Track varible is used to reduce the amount of display() methods being used to output cards or take inputs.
    *After the start() method, track becomes 1, where it cna no longer output.'
    *Unless, the user no longer wanted cards and the house still needs cards, then would print outputs.
    *Or, if user request more cards, sets track to 0, reusing the full display inorder to ask for input again.
    */
    private int track = 0;
  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }
  @Override
    public void display() {
        if(track == 0)//Sets track to 0
        {
            System.out.println("\nHouse's Cards: " + game.getHouseCards());
            System.out.println("Your Cards:    " + game.getYourCards()+"\n");// "\n" creates a new line.
            System.out.print("Would you like more cards? (yes/no):");
            do
            {
                answer = user.nextLine().toLowerCase();//Makes the input lower case for easier evalution.
                System.out.println("");//Used for output formating
                switch (answer) {
                    case "yes":              
                        break;
                    case "no":
                        break;
                    default:
                        System.out.print("Please answer yes or no:");
                        break;
                }
            }while(!(answer.equals("yes")||answer.equals("no")));//If input is not yes/no, repeats request for user input
            track = 1;//Set tack to 1, so durring house's turn, does not output.
        }
        /*If user no longer wants cards but house still requires cards, displays the following output and does not 
        *request an input.
        */
        else if(answer.equals("no"))
        {
            System.out.println("\nHouse's Cards: " + game.getHouseCards());
            System.out.println("Your Cards:    " + game.getYourCards());// "\n" creates a new line.
        }
    }
  @Override
    public boolean hitMe() {
        if(answer.equals("yes"))//Checks if answer is yes. Else, retruns false.
        {
            //After perfoming house's turn, If user wants cards, this reset display to ask for input again durring user's turn.
            track = 0;
            return true;
        }
        return false;      
    }
  @Override
    public void gameOver() {
        int you,house;
        house = game.score(game.getHouseCards());
        you = game.score(game.getYourCards());
        System.out.println("\n\nGame Over");
        System.out.println("House's cards:" + game.getHouseCards());//Display house's cards
        System.out.println("Score:" + house);//Display Score of House
        System.out.println("Your cards:   " + game.getYourCards());//Display your cards
        System.out.println("Score:" + you);//Display Score of User
        if((you<=21 && house<=21)||(you<=21 && house>21))//Narrows down you/house to be <=21 or house>21
        {
            if(you>house || house>21)//User wins if you> house (while <=21) or house>21 (while you <=21)
            {
                System.out.print("\nCongratulations! You won!!!");
            }else if(you < house || you == house)//Rule for this Lab
            {
                System.out.print("\nOuch, you lose.");
            }
        }else if(you>21)//Rule for this Lab
        {
            System.out.print("\nOuch, you lose.");
        }
    }

}