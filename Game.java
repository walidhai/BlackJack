import java.util.*;
import java.io.FileNotFoundException;


public class Game{

  static Deck d1 = new Deck();
  //Task says nothing about userinput, so I interpret user 'Sam' as a given user in the program
  static Player sam = new Player("Sam");
  static Player dealer = new Player("Dealer");
  static int blackjack = 21;

  static void init_deck(String[] args)throws FileNotFoundException{
    if (args.length == 0) {
      d1.self_initialize_deck();
    }else{
      d1.initialize_from_read(args[0]);
    }
  }
  static void start_draw(){
    System.out.println("EACH PARTICIPANT DRAWINS TWO RANDOM CARDS FROM DECK");
    sam.draw_from_deck(d1);
    dealer.draw_from_deck(d1);
    sam.draw_from_deck(d1);
    dealer.draw_from_deck(d1);

    // dealer wins when both players starts with 22 (A + A)
    if (sam.points == 22 || dealer.points == 22) {
      //dealer_win();
      System.out.println("Dealer wins");
    }else if(dealer.points == blackjack || sam.points == blackjack){
      //Player or Sam wins the game
      // player_win();
    }
  }

  static void mid_game(){

  }

  static void late_game(){

  }

  static void start_game(){
    start_draw();
    // if neither player has Blackjack then sam can start drawing cards from the top
    // of the deck
    if (dealer.points==blackjack && sam.points==blackjack) {

    }



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
