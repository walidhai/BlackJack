import java.util.*;
import java.io.File;
import java.lang.Math;
import java.io.FileNotFoundException;


public class Deck{
  static Card[] cardStack;
  int deck_size;

  public Deck(){

  }

  static void initialize_from_read(String filename) {

    //Keeping my scanner and file variablenames short
    File cf = new File(filename);

    try {
      //pass på her pls
      Scanner sc = new Scanner(cf);
      System.out.println("Ikke no piss");

      String fileinput;
      char[] tmp;
      String suiteType;
      String passedValue;

      while(sc.hasNextLine()){
        if(!sc.hasNext()){
          break;
        }
        fileinput = sc.next();
        tmp = fileinput.toCharArray();
        if (tmp.length > 2) {
          System.out.println("yeet");
        }else if(tmp.length<2){
          System.out.println("ERROR: FILE INPUT INVALID");
        }else{

        }


        System.out.println(tmp);

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  static int count_lines(String filename) throws FileNotFoundException{
    File cf = new File(filename);

    Scanner sc = new Scanner(cf);
    int teller = 0;
    while(sc.hasNextLine()){
      if (!sc.hasNext()) {
        break;
      }
      teller++;
    }
    return teller;
  }

  void self_initialize_deck(){
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

  }


  void draw_card(){

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
    int sl = count_lines("Cards1.txt");
    cardStack = new Card[sl];
    initialize_from_read("Cards1.txt");
  }
}
