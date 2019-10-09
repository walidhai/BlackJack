import java.util.*;

public class Card{
  char suit;
  //Using specCard for cards Jack up to Spade so I can print them out as for instance CJ DQ AA etc
  char specCard;
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

  public void card_is_drawn(){
    taken = true;

  }
  public static void main(String[] args) {
    Card c1 = new Card('C', 2);

    System.out.println(c1.suit + c1.val);
  }

}
