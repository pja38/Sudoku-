/*player interface
I don't want anyone to be able to create an 
instance of "Player", but a specific type
of player (NPC or PC) and every player
has to have a getplayer colour and getuserinput method
*/
  
public interface Player{

  /*all methods to be overridden by subclasses

  getUserInput will vary depending on whether
  the player is a human or the computer
  */
  public int getUserInput();

  //getter - returning player colour
  public char getPlayerColour();

  //getter - returning player number
  public int getPlayerNumber();
  
}