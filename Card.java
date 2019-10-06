import java.util.*;

public class Card{
  String suit;
  int val;


  public Card(String suit, int val){
    this.suit = suit;
    this.val = val;
  }

  public static void main(String[] args) {
    Card c1 = new Card("C", 2);

    System.out.println(c1.suit + c1.val);
  }

}
