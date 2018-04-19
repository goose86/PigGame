/*Mike Martinez
 * FourTurns player is a child class of PigPlayer
 * designed to win in four turns
 */


public class FourTurnsPlayer extends PigPlayer{
  private int fourHoldValue;
  private int turnNum;
  
  public FourTurnsPlayer(){
    fourHoldValue = PigGame.GOAL/4 ; 
  }
  /*
  public boolean isRolling(int turnTotal, int opponentScore){   //isRolling method dor UserPigPlayer
    
    if(turnTotal + super.getScore()) < || turnTotal >= PigGame.GOAL)
      return turnTotal + 1;
    else
      return false;
    
  }
  
  /*/ public boolean isRolling(int turnTotal, int opponentScore){ 
     return false;
   
}
}


