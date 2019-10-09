import java.util.*;
import java.io.File;
import java.lang.Math;
import java.io.FileNotFoundException;


public class Deck{
  static Card[] cardStack;
  int deck_size;

  public Deck(){

  }

  static void initialize_from_read(String filename) throws FileNotFoundException{

    //Keeping my scanner and file variablenames short
    // At first glance of the assignment I would have thought all card stacks
    // contains 52 cards. But with a function for reading lines I can easily set
    // up a dynamic size that fits all given files.
    // int sze = 52;
    int sze = count_lines(filename);
    cardStack = new Card[sze];
    Card tempCard;
    File cf = new File(filename);
    int teller = 0;
    try {
      //pass på her pls
      Scanner sc = new Scanner(cf);

      String fileinput;
      char[] tmp;
      String suiteType;
      String passedValue;

      /* Actual reading from
       *
       *
       *
       *
       */
      while(sc.hasNextLine()){
        if(!sc.hasNext()){
          break;
        }
        fileinput = sc.next();
        tmp = fileinput.toCharArray();

        /*   In the events of reading cards from the file I either get lines with
        *    2 characters or 3 characters depending on the score.
        *    3 characters is the special case with cards of value = 10.
        *    Everything under 2 characters and over 3 characters break the fashion
        *    code of cards in this cardgame.
        */
        if (tmp.length == 3) {


          //adding the two numbers and converting to int.

          int a = Integer.parseInt("" +tmp[1] + tmp[2]);
          System.out.println(a);
          tempCard = new Card(tmp[0], a);
          cardStack[teller] = tempCard;

        }else if(tmp.length<2 || tmp.length > 3){
          System.out.println("ERROR: FILE INPUT INVALID");
        }else{
          int a;
          if (tmp[1]=='J'||tmp[1]=='Q'||tmp[1]=='K') {
            a = 10;

            tempCard = new Card(tmp[0], a);
            tempCard.setSpecial(tmp[1]);
            cardStack[teller] = tempCard;

          }else if (tmp[1]=='A') {
            a = 11;

            tempCard = new Card(tmp[0], a);
            tempCard.specCard = tmp[1];
            cardStack[teller] = tempCard;
          }else{

            a = Character.getNumericValue(tmp[1]);
            tempCard = new Card(tmp[0], a);
            cardStack[teller] = tempCard;
          }
        }
        System.out.println(cardStack[teller].suit + cardStack[teller].val);
        teller ++;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  static int count_lines(String filename) throws FileNotFoundException{
    File cf = new File(filename);

    Scanner sc = new Scanner(cf);
    int teller = 0;
    String tmp;
    while(sc.hasNextLine()){
      if (!sc.hasNext()) {
        break;
      }
      tmp = sc.next();
      //System.out.println(teller);
      teller++;
    }
    return teller;
  }

  /*void self_initialize_deck(){
    Card tempCard;
    cardStack = new Card[52];
    deck_size = cardStack.length;
    int counter = 0;

    for (int i = 0;i < 4 ;i++ ) {
      for (int j = 2;j<=14 ;j++ ) {
        tempCard = new Card(" ", 0);
        if (i == 0) {
          if (j<=10) {
            tempCard.suit = "C";
            tempCard.val = j;
            cardStack[counter] = tempCard;
          }else if (j>10) {
            if (j==14) {
              tempCard.suit = "C";
              tempCard.val = 11;
              cardStack[counter] = tempCard;
            }else{
              tempCard.suit = "C";
              tempCard.val = 10;
              cardStack[counter] = tempCard;
            }
          }
        } else if (i == 1) {
          if (j<=10) {
            tempCard.suit = "D";
            tempCard.val = j;
            cardStack[counter] = tempCard;
          }else if (j>10) {
            if (j==14) {
              tempCard.suit = "D";
              tempCard.val = 11;
              cardStack[counter] = tempCard;
            }else{
              tempCard.suit = "D";
              tempCard.val = 10;
              cardStack[counter] = tempCard;
            }
          }
        } else if (i == 2) {
          if (j<=10) {
            tempCard.suit = "H";
            tempCard.val = j;
            cardStack[counter] = tempCard;
          }else if (j>10) {
            if (j==14) {
              tempCard.suit = "H";
              tempCard.val = 11;
              cardStack[counter] = tempCard;
            }else{
              tempCard.suit = "H";
              tempCard.val = 10;
              cardStack[counter] = tempCard;
            }
          }
        }
        else if (i == 3) {
          if (j<=10) {
            tempCard.suit = "S";
            tempCard.val = j;
            cardStack[counter] = tempCard;
          }else if (j>10) {
            if (j==14) {
              tempCard.suit = "S";
              tempCard.val = 11;
              cardStack[counter] = tempCard;
            }else{
              tempCard.suit = "S";
              tempCard.val = 10;
              cardStack[counter] = tempCard;
            }
          }
        }
        //System.out.println(cardStack[counter].suit + cardStack[counter].val);
        counter +=1;
      }
    }

  }*/

  void self_initialize_deck_v2() throws FileNotFoundException{
    initialize_from_read("Self.txt");
  }

  public static Card draw_card(){
    // Instead of stocking the input in the deck randomky, I chose to draw card from a randomk
    // index in the deck using the Math.random extension.
    //
    int min = 0;
    int max = cardStack.length - 1;
    int range = max - min +1;
    int rand = 0;
    boolean drawn = false;
    while(!drawn){
      rand = (int) (Math.random() * range) + min;
      if(cardStack[rand].taken==false){
        cardStack[rand].card_is_drawn();
        System.out.println("Random card: " + cardStack[rand].suit + cardStack[rand].val);
        drawn = true;
      }
      System.out.println("--");
    }
    return cardStack[rand];
  }

  boolean is_empty(){
    if(cardStack == null){
      return true;
    }
    return false;
  }

  public static void main(String[] args) throws FileNotFoundException{
    /*  Deck d1 = new Deck();
    d1.self_initialize_deck();
    for (Card c : d1.cardStack) {
    System.out.println(c.suit + c.val);
  }*/
  /*int sl = count_lines("Cards1.txt");
  cardStack = new Card[sl];
  System.out.println("Size of cardstack is : " + cardStack.length);*/
  initialize_from_read("Self.txt");
  for (Card c : cardStack) {
    System.out.println("Suit: " + c.suit + " Value: " + c.val + " SpecialCard if given: " + c.specCard);
  }
  draw_card();
}
}
