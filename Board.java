

public class Board{

  private char[][] board;
  private boolean win;
  private int noToWin;

  public Board(){
    board = new char[6][7];
    win=false;
    noToWin=4;
  }

  //places counter on the board by checking the first empty slot from the bottom in that column.
  public boolean placeCounter(char colour, int pos){
		boolean placed = false;
		for(int i=board.length-1; i>=0; i--){
			if(!placed){
				if(board[i][pos] == '\0'){
					board[i][pos] = colour;
					placed = true;
				}
			}
		}
    return placed;
	}

  //checking whether there is a winner - checks horizontally, vertically and diagonally 
  public boolean winCheck(char colour){
    boolean win = false;
  	int count = 0;
		// check horizontal
		for(int i=0; i<board.length; i++){
  		for(int j=0; j<board[i].length; j++){
  			if(board[i][j] == colour){
  				count = count + 1;
  				if(count >= noToWin){
  					win = true;
  				}
  			}
  			else{
  				count = 0;
  			}
  		}
      count = 0;
  	}
  	// check vertical 
  	count = 0;
  	for(int i=0; i<board[0].length; i++){
  		for(int j=0; j<board.length; j++){
  			if(board[j][i] == colour){
  				count = count + 1;
  				if(count >= noToWin){
  					win = true;
  				}
  			}
  			else{
  				count = 0;
  			}
  		}
      count = 0;
  	}
    // check diagonal
    //down and right check
    count = 0;
    for(int i=0; i<board.length-noToWin+1; i++){
  		for(int j=0; j<board[i].length-noToWin+1; j++){
        for(int k=0;k<noToWin;k++){
          if(board[i+k][j+k] == colour){
    				count = count + 1;
    				if(count >= noToWin){
    					win = true;
    				}
    			}
    			else{
    				count = 0;
    			}
        }
        count = 0;
  		}
  	}
    //up and right check
    count = 0;
    for(int i=board.length-1; i>noToWin-2; i--){
  		for(int j=0; j<board[i].length-noToWin+1; j++){
        for(int k=0;k<noToWin;k++){
          if(board[i-k][j+k] == colour){
    				count = count + 1;
    				if(count >= noToWin){
    					win = true;
    				}
    			}
    			else{
    				count = 0;
    			}
        }
        count = 0;
  		}
  	}
    return win;
  }

  //method to return printable board as string. prints empty values where there is an empty place, prints counters where there are counters
  public String getBoardToPrint(){
    String brd="";
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] != '\0'){
					brd+="| "+board[i][j]+" ";
				}
				else{
					brd+="|   ";
				}
			}
			brd+="|\n";
		}
		brd+="  1   2   3   4   5   6   7\n";
    return brd;
	}

  //checks whether there are empty spaces on the board or not.
  public boolean boardFullCheck(){
    boolean boardFull=true;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j]=='\0'){
					boardFull=false;
        }
	    }
    }
    return boardFull;
  }
}