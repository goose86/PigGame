/*Michael Martinez
 * PigGame Class
 * A parent class
 */
import java.util.*;                               //Creates Scanner

public class PigGame{
  
  private PigPlayer player1;       //2 instance variables, 2 pig players 
  private PigPlayer player2;
  public static boolean verbose = true;    //boolean variable that stops printing when called false
  public static final int GOAL = 100;      //Static constant
  
  public PigGame(){          //players already initialized
    player1 = new UserPigPlayer("player1");
    player2 = new UserPigPlayer("player2");
  }
  public PigGame(String newPlayer1, String newPlayer2){ //Constructor that takes 2 Strings for the players
    player1 = new UserPigPlayer(newPlayer1);
    player2 = new UserPigPlayer(newPlayer2);
  }
  public PigGame(PigPlayer p1, PigPlayer p2){ //a constructor that takes 2 players
    player1 = p1;
    player2 = p2;
  }
  public void reset(){   //calls the reset method to rest the score for both players
    player1.reset();
    player2.reset();
  }
  public static int playTurn(PigPlayer player, PigPlayer opponent){  //Method that plays the game with PigPlayer
    Die dice = new Die();                                           //and keeps track of the die roll and turn total
    int turnTotal = 0; 
    boolean result = true;
    
    do{                                //Do while loop that tells users if they have rolled a 1
      int roll = dice.roll();
      if (roll == 1 || roll == 0){ 
        if (verbose) {
          System.out.println("Sorry, you rolled a 1, your new point total is 0.");  //Prints the results of rolling a 1
          System.out.println(" ");
          System.out.println("Next player...");
          System.out.println(" ");
        }
        return 0;
      }
      else {
        if (verbose) {
          System.out.println("You rolled a " + roll);
        }
        turnTotal = turnTotal + roll; //<<<
      }
      result = player.isRolling(turnTotal, opponent.getScore());         //Calls the isRolling methid if the player does not roll a 1
    }while(result);
    return turnTotal;
  }
  
  public void playGame(){     //playGame method runs the pig game until you get a winner
    int score1, score2;        //instance variables
    player1.reset();           //resets scores to 0
    player2.reset();
    score1 = 0;
    score2 = 0;
    
    while(player1.won() == false && player2.won() == false){    //While loop checks to see if player has won, and then continues to play when false 
      if (verbose) {
        System.out.println(player1.getName() + " your score total score is " + player1.getScore()); 
        System.out.println(/*player1.getName() + */"and it is your roll.");
      }
      score1 = this.playTurn(player1, player2);
      player1.addPoints(score1);                        //Calls addPoints method that adds points to score when a player holds
      
      
      if(player1.won() == false){
        if (verbose) {
          System.out.println(player2.getName() + " your score total score is " + player2.getScore());  
          System.out.println(/*player2.getName() + " */"and it is your roll.");
        }
        score2 = this.playTurn(player2, player1);
        player2.addPoints(score2);                       //Calls addPoints method that adds points to score when a player holds
        
        
      }
    }
  }
  public static void userVsComputer(){         //User vs Computer method that allows the user the user to play the computer
    if (verbose) {
      System.out.println("Welcome to Pig Game!");                         //Game instructions
      System.out.println("You will now battle a computer to the death!");
      System.out.println(" ");
      System.out.println("-To play, each player will get a chance to roll a die."); 
      System.out.println("-While on your turn, each roll will add points to your total score.");              
      System.out.println("-After each roll, you can decide to keep rolling or pass to your oppenent and keep your points.");                   
      System.out.println("-Be careful, if you roll a 1, your turn is over and your score is reset to 0!");
      System.out.println("-First player to score 100 wins. Good luck, and have fun!");
    }
    String name1;
    Scanner keyboard = new Scanner(System.in);             //Creates scanner
    if (verbose) {
      System.out.println(" ");
      System.out.println("Please enter the first players name:");
    }
    name1 = keyboard.nextLine();               //takes players name
    
    PigPlayer p1 = new UserPigPlayer(name1);             //Creates user player and computer player
    PigPlayer p2 = new SimpleHoldPlayer("T-1000");
    
    if(Math.random() <= 0.5){                // If statement to see who plays first
      if (verbose) {
        System.out.println(name1 + " will be the first to roll! ");
        System.out.println(" ");
      }
      p1 = new UserPigPlayer(name1);
      p2 = new SimpleHoldPlayer("T-1000");
    }
    else{
      if (verbose) {
        System.out.println(p2 + " will be first to roll! ");
        System.out.println(" ");
      }
      p1 = new SimpleHoldPlayer("T-1000");
      p2 = new UserPigPlayer(name1);
    }
    PigGame theGame = new PigGame(p1,p2);
    
    theGame.playGame();  
    
    if(p1.won() == true)      //If statement to to see which player has won
      if (verbose) {
      System.out.println("Congratulations " + p1.getName() + ", you win!");
    }
    else
      if (verbose) {
      System.out.println("Congratulations " + p2.getName() + ", you win!");
    }
  }
  public static void userVsUser(){            //Method that allows 1 player to play against another user, and runs the pig game.
    PigPlayer p1, p2;
    if (verbose) {
      System.out.println("Welcome to Pig Game!");            //Game instructions
      System.out.println(" ");                     
      System.out.println("-To play, each player will get a chance to roll a die.");      
      System.out.println("-While on your turn, each roll will add points to your total score.");              
      System.out.println("-After each roll, you can decide to keep rolling or pass to your oppenent and keep your points.");                   
      System.out.println("-Be careful, if you roll a 1, your turn is over and your score is reset to 0!");
      System.out.println("-First player to score 100 wins. Good luck, and have fun!");
    }
    String name1, name2;
    Scanner keyboard = new Scanner(System.in);
    if (verbose) {                                               
      System.out.println(" ");
      System.out.println("Please enter the first players name:");
    }
    name1 = keyboard.nextLine();
    if (verbose) {
      System.out.println("Plaese enter the second players name:");
    }
    name2 = keyboard.nextLine();
    
    if(Math.random() <= 0.5){      // If statement to see who plays first, also each user is created
      if (verbose) {
        System.out.println(name1 + " will be the first to roll! ");
        System.out.println(" ");
      }
      p1 = new UserPigPlayer(name1);
      p2 = new UserPigPlayer(name2);
    }
    else{
      if (verbose) {
        System.out.println(name2 + " will be first to roll! ");
        System.out.println(" ");
      }
      p1 = new UserPigPlayer(name2);
      p2 = new UserPigPlayer(name1);
    }
    PigGame theGame = new PigGame(p1,p2);              //Creates the game
    
    theGame.playGame();                                               //calls the playGame method
    //if statements
    
    if(p1.won() == true)                                           //If statement to to see which player has won
      if (verbose){
      System.out.println("Congratulations " + p1 + ", you win!");
    }
    else
      if (verbose) {
      System.out.println("Congratulations " + p2 + ", you win!");
    }
  }
  public static void computerVsComputer(){
    if (verbose) {
      System.out.println("Computers will battle to the death");
    }
    PigPlayer robot1 = new SimpleHoldPlayer("The Terminator");
    PigPlayer robot2 = new SimpleHoldPlayer("John Conner");
    
    PigGame theGame = new PigGame(robot1,robot2);       //Creates the game
    
    theGame.playGame();          //Plays the game
    
    if(robot1.won() == true)        //If statement to to see which player has won
      if (verbose) {
      System.out.println("Congratulations " + robot1.getName() + ", you win!");
    }
    else
      if (verbose) {
      System.out.println("Congratulations " + robot2.getName() + ", you win!");
    }
  }
  
  public static void main(String [] args){
    
    //PigGame.userVsComputer(); 
    PigGame.userVsUser();
    //PigGame.computerVsComputer();
  }
  
}
