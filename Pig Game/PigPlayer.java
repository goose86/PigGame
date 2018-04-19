/* Michael Martinez 
 * *PigPlayer*
 * The parent class for all players
 */

public abstract class PigPlayer{  //Parent class for PigPlayers
  private String name;
  private int totalScore, totalWon;
  
  // constructors
  public PigPlayer(){     //Sets the instance variables
    //totalScore = 0;
    totalWon = 0;
    name = "mike";
  }
  
  public PigPlayer(String player){  //Again, sets instance variable to 0 and name to player.
    name = player;
   // totalScore = 0;
    totalWon = 0;
  }
  
  public void setName(String playerName){   //Mutator method
    name = playerName;
  }
  
  public String getName(){       //Accessor method for name
    return name;
  }
  
  public void reset(){        //resets score to 0
    totalScore = 0;
  }
  
  public void addPoints(int turnTotal) {   //Adds the turnTotal to the overall score
    totalScore = totalScore + turnTotal;
    
    if(this.won() == true)       //if statement that keeps tracks of wins
      totalWon = totalWon + 1;
    
  }
  
  public boolean won(){                 //Checks to see of the player won
    if(totalScore >= PigGame.GOAL){
        return true;
    }
  else
    return false;
  }
  
  public int getScore(){        //Accessor method for score
    return totalScore;
  }
  
  public int getWinRecord() {  //Accessor method gets the total win record
    return totalWon;
  }
  
  public String toString(){    //String method returns players name and score
    return "Player, " + name + ", Has a score of " + totalScore;
  }
  
  public abstract boolean isRolling(int turnTotal, int opponentScore);  //abstract method that will be called in the child classes
  
  
    
  /*public static void main(String [] args){
  }*/
  
}