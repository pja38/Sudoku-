

public class C4Mechanics{

  private Board board;
  private Player player1;
  private Player player2;

  public C4Mechanics(){
    //new board & new players
    board=new Board();
    player1=new PC('b',1);
    player2=new PC('y',2);
  }

  public void playGame(){
    //prints instructions
		Instructions.printInstructions();
    //printing empty board for user to see
		System.out.println(board.getBoardToPrint());
    //end becomes true when board full or player wins
		boolean end = false;
    //draw true when board full and no player has won
    boolean draw = false;
    //setting first player as player1
    Player player=player1;
    //while loop continues until there's a winner or board is full
		while(!end){
      boolean placed=false;
      //do while loop ensures player has a valid move. repeats until placed=true
			do{
        //gets player input - whether human or computer
        int move=player.getUserInput();
        //places counter on board
			  placed=board.placeCounter(player.getPlayerColour(),move-1);
        //placed=false if column full, so player needs to choose a different column
        if(!placed){
          System.out.println("Column full, please pick a different slot");
        }
        else{
          //prints board
			    System.out.println(board.getBoardToPrint());
        }
      }while(!placed);
      //checks whether that move now means the current player has won
			if(board.winCheck(player.getPlayerColour())){
				end = true;
			}
      //if the player hasn't won, checks if board is full and therefore draw
      else if(board.boardFullCheck()){
        end = true;
        draw = true;
      }
      //if player did not win and board not full, the players change over
			else{
        if (player.equals(player1)){
          player=player2;
        }
        else{
          player=player1;
        }
      }
			
		}
    //game over messages displayed if while loop terminates
    if(draw){
      System.out.println("It's a draw!!!");
    }
    else{
      System.out.println("Player "+player.getPlayerNumber()+" won with "+player.getPlayerColour()+"!");
    }
	}

  
}