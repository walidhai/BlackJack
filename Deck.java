import java.util.*;

public class Deck{
  Card[] cardStack;

  public Deck(){

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
