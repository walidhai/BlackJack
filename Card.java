import java.util.*;

public class Card{
  String suit;
  //Using specCard for cards Jack up to Spade so I can print them out as for instance CJ DQ AA etc
  String specCard;
  int val;
  boolean taken = false;


  public Card(String suit, int val){
    this.suit = suit;
    this.val = val;

  }

  
  public static void main(String[] args) {
    Card c1 = new Card("C", 2);

    System.out.println(c1.suit + c1.val);
  }

}
