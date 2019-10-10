import java.util.*;
import java.io.FileNotFoundException;


public class Game{

  static Deck d1 = new Deck();
  Player sam = new Player("Sam");
  Dealer dealer = new Dealer();

  static void init_deck(String[] args)throws FileNotFoundException{
    if (args.length == 0) {
      d1.self_initialize_deck();
    }else{
      d1.initialize_from_read(args[0]);
    }
  }

  static void start_game(){

  }

  public static void main(String[] args) throws FileNotFoundException{
    init_deck(args);
    for (Card c: d1.cardStack ) {
      System.out.println(c.suit + " "+ c.val);
    }

  }
}
