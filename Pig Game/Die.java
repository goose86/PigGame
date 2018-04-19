/** Michael Martinez
  * Die Class that creates the die and its sides
  * for PigGame
  */
public class Die{
  // number of sides
  private int sides = 6;   
  
  // constructors
  
  public Die(){
    // sides already set to 6 
  }
  
  public Die(int theSides){
    if(theSides > 0)   // if-statement to validate sides
      sides = theSides;
  }
  public static int roll(){    //Method that rolls a 6 sided die
    int rollNumber;
    double diceRoll;
    diceRoll = ((Math.random()*6));   //Calls math.random to get roll #
    rollNumber = (int)diceRoll + 1;
    
    return rollNumber;
  }
  
  public void setSides(int numberOfSides) {  //Mutator method that sets side
    if(numberOfSides > 0)
      sides = numberOfSides;
  }
  
  public int getSides(){       //Accessor that gets sides
    return sides;
  }
  
  public int rollDie(){       //Method to roll die on a multiple sided die
    
    int rollNumber;
    double number2;
    number2 = ((Math.random()*12) + 1);   //Calls math.random and creates multi sided die
    rollNumber = (int)number2;
    
    return rollNumber;          //returns a number that was rolled
    
    
  }
  
  public static void main(String [] args){    //Main method checks to see if the methods are working
    
    int [] array = new int[7];               //for loop that checks the number of times each number is rolled
    for (int i=0; i<200; i++) {
      array[Die.roll()]++;
    }
    for(int i =0 ; i < 7; i++){
      System.out.print(array[i] + " ");
    }
    
    /* Die twelve = new Die(12);
     System.out.println(twelve.getSides());
     for (int i=0; i<60; i++) 
     System.out.println(twelve.rollDie());
     */
  }
}


