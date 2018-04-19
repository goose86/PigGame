/*Michael Martinez
 * SimpleHoldPlayer Class is a child class of PigPlayer
 */

public class SimpleHoldPlayer extends PigPlayer{
  private int holdValue;
  
  public SimpleHoldPlayer(){                 //Constructors ||
    super();                                 //            \||/
    holdValue = 20;                            //           \/  
  }
  public SimpleHoldPlayer(String simpleName){  
    super(simpleName);                                      
    holdValue = 20;                                           
  }
  public SimpleHoldPlayer(String simpleName2, int holdValue2){
    super(simpleName2);
    holdValue2 = holdValue;
    
  }
  
  public boolean isRolling(int turnTotal, int opponentScore){   //isRolling method for UserPigPlayer
    boolean rollIt = false;;
   
    if(turnTotal >= holdValue|| turnTotal + this.getScore() >= PigGame.GOAL){
      return false;
    }
    
     else if(turnTotal < holdValue)
       return true;
     
     return rollIt;
   }

}