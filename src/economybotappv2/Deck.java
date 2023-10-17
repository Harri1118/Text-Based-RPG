/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import java.sql.Types;
import java.util.ArrayList;
//import economybotCard;

/**
 *
 * @author Harri
 */
public class Deck {

    private String[] Types = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private int count;
    ArrayList<Card> testDeck = new ArrayList<Card>();
    public void Deck(ArrayList<Card> c) {

        if (!(c.size() > 52)) {
            CardAdder("Ace", 1, c);
            CardAdder("Two", 2, c);
            CardAdder("Three", 3, c);
            CardAdder("Four", 4, c);
            CardAdder("Five", 5, c);
            CardAdder("Six", 6, c);
            CardAdder("Seven", 7, c);
            CardAdder("Eight", 8, c);
            CardAdder("Nine", 9, c);
            CardAdder("Ten", 10, c);
            CardAdder("Jack", 10, c);
            CardAdder("Queen", 10, c);
            CardAdder("King", 10, c);

            testDeck = c;
        }
    }

    public void clear(ArrayList<Card> c){
    c.removeAll(c);
    }
    public void removeHalf(ArrayList<Card> c) {
        for (int i = 52; i < c.size(); i++) {
            if (i > 52) {
                c.remove(c.get(i));
            }
        }
    }

    public void shuffle(ArrayList<Card> c) {
        ArrayList<Card> n = new ArrayList();
        for (int i = 0; i < 52; i++) {
            int r = (int) (Math.random() * (c.size()));
            Card t = c.get(r);
            c.remove(r);
            n.add(t);
        }
        //c = n;
        c.clear();
        for (int i = 0; i < n.size(); i++) {
            c.add(n.get(i));
        }
    }
    
    public int pointTotal(ArrayList<Card> c){
    int a = 0;
    for(int i = 0; i < c.size(); i++){
   // a += c.get(i).getNum();
    }
    return a;
    }
//LOCAL METHODS
    private boolean checkRepeat(int i, int[] c) {
        for (int n = 0; n < c.length; n++) {
            if (i == c[n]) {
                return true;
            }
        }
        return false;
    }

    private void CardAdder(String s, int n, ArrayList<Card> c) {
        for (int i = 0; i < 4; i++) {
            c.add(new Card(s, n));
            c.get(count).setType(Types[i]);
            count++;
        }
    }

    private void CardAdder(String s, ArrayList<Card> c) {
        for (int i = 0; i < 4; i++) {
            c.add(new Card(s));
            c.get(count).setType(Types[i]);
            count++;
        }
    }

    private int GetPos(Card i, ArrayList<Card> c) {
        int pos = 0;
        for (int n = 0; n < c.size() - 1; n++) {
            if (i.toString().equals(c.get(n).toString()))
                return pos;
            
        }
        return -1;
    }
//TEST METHODS

    public String toString(ArrayList<Card> c) {
        String ret = "";
        for (int i = 0; i < c.size(); i++) {
            ret += testDeck.get(i).toString();
        }
        ret += "Total Cards in deck: " + count;
        
        return ret;
    }
   
   /* public void swap(int a, int b, ArrayList<Card> A, ArrayList<Card> B){
        Card f = A.get(a);
        Card s = B.get(b);
        A.set(a, s);
        B.set(b, f);
    }*/

    void swap(int a, int b, ArrayList<Card> A, ArrayList<Card> B) {
        Card f = A.get(a);
        Card s = B.get(b);
        A.set(a, s);
        B.set(b, f);
    }
}
