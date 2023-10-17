/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;
import economybotappv2.Deck;
import economybotappv2.Card;
import java.util.ArrayList;
public class DeckExperiment {
  private static String res = "";
  public static void main(String[] args)  {
      Deck ExperimentDeck = new Deck();
      ArrayList<Card> c = new ArrayList<Card>();
  ExperimentDeck.Deck(c);
  ExperimentDeck.shuffle(c);
 for(int i = 0; i < c.size(); i++){
  Card t = c.get(i);
  for(int n = 0; n < c.size(); n++){
     if(n == i){
System.out.println("");
  }
     else if((t.toString().equals(c.get(n).toString()))){
      System.out.println("Match found");}
  }
  }
 System.out.println(ExperimentDeck.toString(c));
   }
  
  
  
  }
 
 /* public String RepeatChecker(ArrayList<Card> c){
  for(int i = 0; i < c.size(); i++){
  Card t = c.get(i);
  for(int n = 0; n < c.size(); n++){
  if((t.toString().equals(c.get(n).toString())))
      return "Match found";
  }
  }
      return "Clean!";*/
  
