import java.util.*;
import java.lang.Math;


public class Deck{
  Card[] cardStack;
  int deck_size;

  public Deck(){

  }

  void initialize_from_read(){
    Scanner sc = new Scannes(System.in);
    
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

  public static void main(String[] args) {
    Deck d1 = new Deck();
    d1.self_initialize_deck();
    for (Card c : d1.cardStack) {
      System.out.println(c.suit + c.val);
    }

  }
}
