/*Mike Martinez 
 * WatchOpponentPlayer is a child class of PigPlayer
 */

public class WatchOpponentPlayer extends PigPlayer{
  private int holdValue1;
  private int holdValue2;
  private int closeNum;
  private int numberDiff;
  
  public WatchOpponentPlayer(){
    holdValue1 = PigGame.GOAL/5;
    holdValue2 = holdValue1;
    closeNum = 75;
    numberDiff= 2;
    
  }
  
  public boolean isRolling(int turnTotal, int opponentScore){ 
    if(turnTotal + super.getScore() < PigGame.GOAL){
      if(turnTotal < holdValue2){
        if(turnTotal + super.getScore() > closeNum || opponentScore > closeNum){
          return true;
          
        }
        else if ((turnTotal + super.getScore()) < opponentScore){
          holdValue2 = holdValue1 + ((opponentScore - (turnTotal + super.getScore()) / numberDiff));
        }
        else if ((turnTotal + super.getScore()) > opponentScore){
          holdValue2 = holdValue1 + ((opponentScore - (turnTotal + super.getScore()) / numberDiff));
        }
        
      }
    }
    return false;
  }
}

