import java.util.Random;

//implements Player interface - computer run
public class NPC implements Player{

  private char colour;
  private int number;
  
  public NPC(char colour,int number){
    this.colour=colour;
    this.number=number;
  }

  /*overrides getUserInput with simple random
  integer generator from 1-7 (expected user inputs)
  */
  @Override
  public int getUserInput(){
    Random rdm = new Random();
  	return rdm.nextInt(7)+1;
	}

  //returns players colour
  @Override
  public char getPlayerColour(){
    return colour;
  }

  //returns players number
  @Override
  public int getPlayerNumber(){
    return number;
  }
  
}