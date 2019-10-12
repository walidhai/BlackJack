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
    if (sam.points == 22 && dealer.points == 22) {
      //dealer_win();
      System.out.println("Dealer wins");
    }else if(dealer.points == blackjack && sam.points == blackjack){
      //Player or Sam wins the game
      // player_win();
    }
  }

  static void player_draws(Player p){
    boolean tt = true;
    while(tt){
      //sam must stop drawing cards from the deck if their total reaches 17 or higher
      if (p.points >= 17) {
        //sam has lost the game if their total is higher than 21
        if (p.points>21) {
          //dealer_win();
          System.out.println("u Lost! " + p.points);
          tt=false;
        }
        System.out.println(p.points);
        tt=false;
        break;
      }else{
        p.draw_from_deck(d1);
      }
    }
  }

  static void dealer_draws(Player p1, Player p2){
    boolean tt = true;
    while(tt){
      if (p1.points < 21) {
        //player_win();
        System.out.println("Du tapte din taper");
        tt = false;
      }else if (p1.points>p2.points) {
        System.out.println("STOPSTOPSTOP!!! : DEALER POINTS AND PLAYER POINTS: " + p1.points + p2.points);
        tt = false;
      }

      p1.draw_from_deck(d1);
    }
  }

  static void start_game(){
    start_draw();
    // if neither player has Blackjack then sam can start drawing cards from the top
    // of the deck
    if (dealer.points==blackjack) {
      //dealer_win();
    } else if (sam.points == blackjack) {
      // player_win();
    }




  }

  public static void main(String[] args) throws FileNotFoundException{
    init_deck(args);
    /*for (Card c: d1.cardStack ) {
      System.out.println(c.suit + " "+ c.val);
    }*/

    start_draw();

    player_draws(sam);
    dealer_draws(dealer, sam);
    sam.display_hand();
    dealer.display_hand();

  }
}
