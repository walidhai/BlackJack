import java.util.*;
import java.io.FileNotFoundException;


public class Game{

  static Deck d1 = new Deck();
  static Player sam = new Player("Sam");
  static Dealer dealer = new Dealer();

  static void init_deck(String[] args)throws FileNotFoundException{
    if (args.length == 0) {
      d1.self_initialize_deck();
    }else{
      d1.initialize_from_read(args[0]);
    }
  }
  static void start_draw(){
    sam.draw_from_deck(d1);
    sam.draw_from_deck(d1);
    dealer.draw_from_deck(d1);
    dealer.draw_from_deck(d1);

    if (sam.points == 22 || dealer.points == 22) {
      System.out.println("Dealer wins");
    }
  }

  static void start_game(){

  }

  public static void main(String[] args) throws FileNotFoundException{
    init_deck(args);
    /*for (Card c: d1.cardStack ) {
      System.out.println(c.suit + " "+ c.val);
    }*/
    start_draw();
    start_draw();
    start_draw();
    sam.display_hand();
    dealer.display_hand();

  }
}
