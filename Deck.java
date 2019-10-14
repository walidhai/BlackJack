import java.util.*;
import java.io.File;
import java.lang.Math;
import java.io.FileNotFoundException;


public class Deck{
  Card[] cardStack;
  //HashMap<String, Integer> cards = new HashMap<String, Integer>();
  int deck_size;

  public Deck(){

  }

  boolean bad_char(char c){
    //J Q K A legal
    String s = "BCDEFGHILMNOPRSTUVWXYZ";
    char[] illegalChars = s.toCharArray();
    for (int i = 0;i<illegalChars.length ; i++) {
      if (c == illegalChars[i]) {
        return true;
      }
    }
    return false;
  }

  void initialize_from_read(String filename) throws FileNotFoundException{

    /*Keeping my scanner and file variablenames short
     At first glance of the assignment I would have thought all card stacks
     contains 52 cards. But with a function for reading lines I can easily set
     up a dynamic size that fits all given files.*/
    // int sze = 52;
    int sze = count_lines(filename);
    cardStack = new Card[sze];

    Card tempCard;
    File cf = new File(filename);
    int teller = 0;
    try {

      Scanner sc = new Scanner(cf);

      String fileinput;
      char[] tmp;
      String suiteType;
      String passedValue;

      /* Actual passing files in the card game contains lines such as the ones given in Self.txt
       * and look like H2, H4, H5 ... HA (as an example)
       */
      while(sc.hasNextLine()){
        if(!sc.hasNext()){
          break;
        }

        fileinput = sc.next();
        tmp = fileinput.toCharArray();

        //Checks if given text in file has valid value
        if (bad_char(tmp[1])) {
          System.out.println("ERROR: FILE TEXT INVALID");
          System.exit(0);
        }
        
       /*   In the events of reading cards from the file I either get lines with
            2 characters or 3 characters depending on the score.
            3 characters is the special case with cards of value = 10.
            Everything under 2 characters and over 3 characters break the fashion
            code of cards in this cardgame.
        */
        if (tmp.length == 3) {

          //adding the two digits and converting to int.
          int a = Integer.parseInt("" +tmp[1] + tmp[2]);
          if (a>10) {
            System.out.println("ERROR: FILE INPUT INVALID - NUMBERS TOO BIG FOR CARDS");
            System.exit(0);
          }
          tempCard = new Card(tmp[0], a);
          cardStack[teller] = tempCard;

          /*
            Playing around with HashMap. here is how we could add cards to a hashmap.
            Using the cards as keys in the HashMap would prevent any duplicates of cards.
            cards.put(fileinput, tempCard.getVal());
            for(String i : cards.keySet()){
            System.out.println("key:" + i + "val:" + cards.get(i));
          }*/

        }else if(tmp.length<2 || tmp.length > 3){
          System.out.println("ERROR: FILE INPUT INVALID - DIGITS TOO LONG FOR CARDS");
          System.exit(0);
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
    if (teller<4) {
      System.out.println("FILE NOT LONG ENOUGH TO CONTAIN A DECK THAT CAN BE USED IN THE CARD GAME");
      System.exit(0);
    }
    return teller;
  }


  void self_initialize_deck() throws FileNotFoundException{
    initialize_from_read("Self.txt");
  }

  public Card draw_card(){
    /* Instead of stocking the input in the deck randomy, I chose to draw card from a random
       index in the deck using Math.random.*/
    int min = 0;
    int max = cardStack.length - 1;
    int range = max - min +1;
    int rand = 0;
    boolean drawn = false;

    while(!drawn){
      rand = (int) (Math.random() * range) + min;
      if(cardStack[rand].taken==false){
        cardStack[rand].card_is_drawn();
        drawn = true;
      }
    }
    return cardStack[rand];
  }

  boolean is_empty(){
    if(cardStack == null){
      return true;
    }
    return false;
  }

}
