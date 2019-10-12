import java.util.*;
import java.util.ArrayList;
public class Player {
  ArrayList<Card> hand = new ArrayList<Card>();
  String name;
  int points = 0;

  public Player(String name){
    this.name = name;
  }

  public void draw_from_deck(Deck d){
    Card tmp = d.draw_card();
    hand.add(tmp);
    points += tmp.val;
  }

  public void display_hand(){
    System.out.println(name + "'s HAND CONTAINS: '");
    for (Card c: hand ) {
      if (c.specCard!=' ') {
        System.out.println(""+ c.suit + c.specCard);
      }else{
        System.out.println(""+ c.suit + c.val);
      }
    }
    System.out.println("------ DONE ------");
  }

}
