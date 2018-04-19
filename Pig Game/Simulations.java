/*Michael Mrtinez
 * Simulations class for Pig Game
 * that runs multiple games with the 
 * different players.
 */

public class Simulations{
  
  public static void firstAdvantage(long simulations){  //Method that gets calculates the best advantage
    int winRec1, winRec2;
    PigPlayer player1 = new SimpleHoldPlayer();     //Creates 2 new SimpleHoldPlayers players
    PigPlayer player2 = new SimpleHoldPlayer();
    
    for(int i = 0; i < simulations;i++){               //For loop that plays multiple games to get scores 
      PigGame theGame = new PigGame(player1,player2);
      theGame.playGame();  
    }
    winRec1 = player1.getWinRecord();                   // calls the getWinRecord method
    winRec2 = player2.getWinRecord();
    
    System.out.println("Player 1 wins " + ((double)winRec1/simulations * 100) + "% of the time");
  } 
  public static double comparePlayers(long simulations, PigPlayer first, PigPlayer second){  //Method that compares multiple players whle removing the bias of who goes forst
    first = new SimpleHoldPlayer();              //Creates new players
    second = new SimpleHoldPlayer();
    int winRec1, winRec2;
    
    for(int i = 0; i < simulations/2.0;i++){             //For loop with 1/2 the simulations 1st player 1st, then the 2nd player 1st
      PigGame theGame = new PigGame(first,second);
      theGame.playGame();  
      theGame.reset();
    }
    
    for(int i = 0; i < simulations/2.0;i++){
      PigGame theGame = new PigGame(second,first);
      theGame.playGame();  
    }
    winRec1 = first.getWinRecord();               //Calls getWinRecord method
    winRec2 = second.getWinRecord();
    
    return (double)(winRec1)/simulations;
  }
  
  public static double BestHoldValue(long simulations){     //Still working on!!............Method that gets the Best Hold Value
    int bestHold = 0;
    PigPlayer play1 = new SimpleHoldPlayer();
    PigPlayer play2 = new SimpleHoldPlayer();
    
    for(int i = 0; i < simulations;i++){            
      PigGame theGame = new PigGame(play1,play2);
      theGame.playGame();  
    }
    return bestHold; 
  }
  
  public static void findGoodWatchValues(long simulations, PigPlayer first, PigPlayer second){
    PigPlayer play1 = new SimpleHoldPlayer();
    PigPlayer play2 = new SimpleHoldPlayer();
    
    
  }
}




/*
public static void main(String [] args){        //Main Method to call the different methods
  
  //Simulations.firstAdvantage(10000);
  PigPlayer play1 = new SimpleHoldPlayer();
  PigPlayer play2 = new SimpleHoldPlayer();
  System.out.println(Simulations.comparePlayers(10000, play1, play2));
}

}
*/


