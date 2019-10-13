import java.util.*;
import java.io.FileNotFoundException;


public class Game{

  static Deck d1 = new Deck();
  //Task says nothing about user input, so I interpret user 'Sam' as a given user in the program
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


  /*each player is given two cards from the top of a shuffled deck of cards. Cards
    are given in the following order: [sam, dealer, sam, dealer]*/
  static void start_draw(Player player, Player dealer){
    System.out.println("EACH PARTICIPANT DRAWS TWO RANDOM CARDS FROM DECK");

    player.draw_from_deck(d1);
    dealer.draw_from_deck(d1);
    player.draw_from_deck(d1);
    dealer.draw_from_deck(d1);

    // dealer wins when both players starts with 22 (A + A)
    if (player.points == 22 && dealer.points == 22) {
      dealer_win(player, dealer);
      System.out.println("Dealer wins");
    }else if(dealer.points == blackjack && player.points == blackjack){
      //Player or Sam wins the game
      player_win(player, dealer);
    }
  }

  static void player_draws(Player player, Player dealer){
    boolean tt = true;

    while(tt){
      //sam must stop drawing cards from the deck if their total reaches 17 or higher
      if (player.points >= 17) {
        //sam has lost the game if their total is higher than 21
        if (player.points>21) {
          dealer_win(player, dealer);
        }
        System.out.println(player.points);
        tt=false;
        break;
      }else{
        player.draw_from_deck(d1);
      }
    }
  }

  static void dealer_draws(Player player, Player dealer){
    boolean tt = true;

    while(tt){
      if (dealer.points > 21) {
        //the dealer has lost the game if their total is higher than 21
        player_win(player, dealer);
      }else if (dealer.points>player.points) {
        //the dealer must stop drawing cards when their total is higher than sam.
        tt = false;
        break;
      }

      dealer.draw_from_deck(d1);
    }
  }

  static void print_results(Player p1, Player p2){
    System.out.printf("[%s|%s]\n", p1.name, p2.name);
    p1.display_hand();
    System.out.println();
    p2.display_hand();
    System.out.println("\n Points from " + p1.name + ": " + p1.points + " and " + p2.name + ": " + p2.points);
  }


  static void player_win(Player player, Player dealer){
    System.out.printf("PLAYER %s WINS \n", player.name);
    print_results(player, dealer);
    System.exit(0);
  }

  static void dealer_win(Player dealer, Player player){
    System.out.println("Dealer WINS \n");
    print_results(dealer, player);
    System.exit(0);
  }

  static void start_game(Player player, Player dealer){
    start_draw(player, dealer);
    // if neither player has Blackjack then sam can start drawing cards from the top
    // of the deck
    if (dealer.points==blackjack) {
      dealer_win(dealer, player);
    } else if (player.points == blackjack) {
       player_win(player, dealer);
    }

    player_draws(player, dealer);
    dealer_draws(player, dealer);
    if (player.points>dealer.points) {
      player_win(player, dealer);
    }else{
      dealer_win(player, dealer);
    }


  }

  public static void main(String[] args) throws FileNotFoundException{
    init_deck(args);

    start_game(sam, dealer);

  }
}
