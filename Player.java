import java.util.*;
import java.util.ArrayList;
public class Player {
  ArrayList<Card> hand = new ArrayList<Card>();
  String name;
  int point = 0;

  public Player(String Name){
    this.name = name;
  }

  public void draw_from_deck(Deck d){
    hand.add(d.draw_card());
  }

}
