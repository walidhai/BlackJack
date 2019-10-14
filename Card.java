import java.util.*;

public class Card{
  char suit;
  //Using specCard for cards Jack up to Spade so I can print them out as for instance CJ DQ AA etc
  // at the end of the game.
  char specCard = ' ';
  int val;
  boolean taken = false;


  public Card(char suit, int val){
    this.suit = suit;
    this.val = val;
    this.specCard = ' ';
  }

  public void setSpecial(char c){
    specCard = c;
  }

  public int getVal(){
    return val;
  }

  //Used later in Deck.java to mark as drawn.
  public void card_is_drawn(){
    taken = true;
  }

}
