import java.io.*;

//implements player interface - human user - requires inputs
public class PC implements Player{

  //buffered reader to read user input
  private BufferedReader input;
  private char colour;
  private int number;

  public PC(char colour, int number){
    this.colour=colour;
    this.number=number;
    input = new BufferedReader(new InputStreamReader(System.in));
  }


  //overrides getUserInput 
  @Override
  public int getUserInput(){
    int move;
    //try/catch used to ensure any errors are dealt with - e.g. if user input not integer value or IOException
    try{			
  		String userInput = input.readLine();
			move = Integer.parseInt(userInput);
  	}
    /*if block of code above fails, then move=-1,
    which essentially forces the while loop
    and asks user for their input again and 
    clarifies what their input needs to be 
      */
  	catch(Exception e){
  		move=-1;
  	}
    //while loop to deal with any unexpected inputs
    while(move>7||move<1){
      System.out.println("Sorry, it has to be between 1 and 7 inclusive.");
  		try{			
    		String userInput = input.readLine();
  			move = Integer.parseInt(userInput);
    	}
    	catch(Exception e){
    		move=-1;
    	}
  	}
    return move;
  }

  //returns players colour
  @Override
  public char getPlayerColour(){
    return colour;
  }

  //returns players colour
  @Override
  public int getPlayerNumber(){
    return number;
  }
  
}