import java.util.*;
import java.lang.Math;

public class Deck{
  Card[] cardStack;
  int deck_size;

  public Deck(){

  }

  void self_initialize_deck(){
    cardStack = new Card[52];
    deck_size = cardStack.length;

    for (int i = 0;i < deck_size ;i++ ) {
      for (int j = 1;j<=13 ;j++ ) {
        if (i == 0) {
          if (j<10) {
            
          }
        } else if (i == 1) {

        } else if (i == 2) {

        }
        else if (i == 3) {

        }
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
}
