/*import java.util.*;
import java.lang.Math;

public class MyDeck{
  Card[] cardStack;
  int deck_size;

  public MyDeck(){

  }

  void self_initialize_deck(){
    cardStack = new Card[52];
    deck_size = cardStack.length;
    int counter = 0;

    for (int i = 0;i < 4 ;i++ ) {
      for (int j = 2;j<=14 ;j++ ) {
        if (i == 0) {
          if (j<=10) {
            cardStack[counter].suit = "C";
            cardStack[counter].val = j;
          }else if (j>10) {
            if (j==14) {
              cardStack[counter].suit = "C";
              cardStack[counter].val = 11;
            }else{
              cardStack[counter].suit = "C";
              cardStack[counter].val = 10;
            }
          }
        } else if (i == 1) {
          if (j<=10) {
            cardStack[counter].suit = "D";
            cardStack[counter].val = j;
          }else if (j>10) {
            if (j==14) {
              cardStack[counter].suit = "D";
              cardStack[counter].val = 11;
            }else{
              cardStack[counter].suit = "D";
              cardStack[counter].val = 10;
            }
          }
        } else if (i == 2) {
            if (j<=10) {
              cardStack[counter].suit = "H";
              cardStack[counter].val = j;
            }else if (j>10) {
              if (j==14) {
                cardStack[counter].suit = "H";
                cardStack[counter].val = 11;
              }else{
                cardStack[counter].suit = "H";
                cardStack[counter].val = 10;
              }
            }
        }
        else if (i == 3) {
          if (j<=10) {
            cardStack[counter].suit = "S";
            cardStack[counter].val = j;
          }else if (j>10) {
            if (j==14) {
              cardStack[counter].suit = "S";
              cardStack[counter].val = 11;
            }else{
              cardStack[counter].suit = "S";
              cardStack[counter].val = 10;
            }
          }
        }
        counter ++;
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

  public static void main(String[] args) {
    MyDeck d1 = new MyDeck();
    d1.self_initialize_deck();
    for (Card c : d1.cardStack) {
      System.out.println(c.suit + c.val);
    }

  }
}
*/
