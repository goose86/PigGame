/*Michael Martinez
 * UserPig player is a child class to PigPlayer
 * and is the player humans control
 */

import java.util.*;                               //Creates Scanner

public class UserPigPlayer extends PigPlayer{      //Child class of PigPlayer
  
  public UserPigPlayer(String theName){        //Constructor that takes a string name.
    super(theName);
  }
  public boolean isRolling(int turnTotal, int opponentScore){   //isRolling method dor UserPigPlayer
    
    //String name = super.getName();
    Scanner keyboard = new Scanner(System.in);                  //Creates scanner
    System.out.println("Your current roll score is " + turnTotal + ".");  //Prints the players total score
    System.out.println("Press enter to roll again or type any letter to stop.");  //Prompts the player when to stop
    
    String enter = keyboard.nextLine();         //returns whether the player decides to roll again or not
    if(enter.equals(""))
      return true;
    else
      return false;
  }
}

    
  

  
  
