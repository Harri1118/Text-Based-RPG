/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import static economybotappv2.AbstractCode.Opponent;
import static economybotappv2.AbstractCode.Players;
import static java.lang.System.console;
import java.util.ArrayList;

/**
 *
 * @author Harri
 */
public class BlackJack {

    public static boolean gameTime = false;

    public boolean gameHasStarted = false;
    public boolean Playermove = false;
    public boolean NPCmove = false;
    public boolean PlayerAction = false;
    public  boolean NPCAction = false;

    public boolean PlayerHitAction = false;
    public boolean PlayerPassAction = false;
    public boolean PlayerRevealAction = false;
    private boolean aceChoice = false;
    
    private Deck Prep = new Deck();
    private ArrayList<Card> CardDeck = new ArrayList<Card>();

    public String output = "";

    private NPCCode player;

    private int c;
    private int myValue = 0;
    private int opponentValue = 0;
    private int acePosition = -1;
    private int infoSize = 0;
    public int trueSize;
    
    public static double betValue;
    private ArrayList<Card> userInfo = new ArrayList<Card>();
    private ArrayList<Card> npcInfo = new ArrayList<Card>();
    
    private String ending = "(Press enter to continue)\n";
    private String endingResults = "(Press enter twice to continue)\n";
   
    public String BlackJack(String s) {
        if (gameHasStarted == false && Playermove == false && NPCmove == false && PlayerAction == false && NPCAction == false) {
            printerMethod();
            Prep.Deck(CardDeck);
            Prep.shuffle(CardDeck);
            c = this.chance();
            //c = 2;
            this.load(userInfo, c);
            this.load(npcInfo, c);
            printerMethod();
            gameHasStarted = true;
            if (c == 2) {
                Playermove = true;
            } else {
                NPCmove = true;
            }
            if(s.equals("ace")){
            AceTester();
            }
            return "Let's see who goes first...\n" + ending;
        } else if (gameHasStarted == true && Playermove == true && NPCmove == false && PlayerAction == false && NPCAction == false) {
            PlayerAction = true;
            if(hasAce(userInfo) == true){
                aceChoice = true;
                infoSize = 2;}
            else
                infoSize = 0;
            return this.info(infoSize);
        } else if (gameHasStarted == true && Playermove == false && NPCmove == true && PlayerAction == false && NPCAction == false) {
            NPCAction = true;
            return "Your opponent, " + NPCCode.name + ", is making his move... \n" + ending;
// return "Your opponent, " + NPCCode.name + ", has " + npcInfo.size() + " cards.";
        } else if (gameHasStarted == true && Playermove == true && NPCmove == false && PlayerAction == true && NPCAction == false) {
            if(hasAce(userInfo) == true){
                aceChoice = true;
                if(s.equals("make 11")){
                    acePointer(userInfo, 11);
                    aceChoice = false;
                return "You have chosen to gain 11 points! (Press enter to continue)";}}
              /*  if (s.equals("1") && aceChoice == true) {
                    acePointer(userInfo, 1);
                    aceChoice = false;
                    return "You have chosen to gain 1 point! (Press any button to continue)";
                } else if (s.equals("2") && aceChoice == true) {
                    acePointer(userInfo, 11);
                    aceChoice = false;
                    return "You have chosen to gain 11 points! (Press enter to continue)"; 
                }*/
            if (s.equals("1")) {
                PlayerHitAction = true;
                this.Hit(userInfo, s);
            } else if (s.equals("2")) {
                this.Pass(userInfo, s);
            } else if (s.equals("3")) {
                this.Reveal(userInfo, s);
            }
            if (PlayerHitAction == true) {
                PlayerHitAction = false;
                PlayerAction = false;
                Playermove = false;
                NPCmove = true;
                this.printerMethod();
                return "You've recieved a card! " + ending ;
            } else if (PlayerPassAction == true) {
                PlayerPassAction = false;
                PlayerAction = false;
                NPCmove = true;
                return "You passed your turn! " + ending;
            } else if (PlayerRevealAction == true) {
                PlayerRevealAction = false;
                myValue += this.pointCompiler(userInfo);
                opponentValue = this.pointCompiler(npcInfo);
                int myValue = this.myValue;
                int opponentValue = this.opponentValue;
                gameTime = false;
                if ((myValue > opponentValue && myValue <= 21) || (opponentValue > 21 && myValue <= 21)) {
                    PanelVersion.UserBalance += betValue;
                    AbstractCode.Opponent.setBal(Opponent.getBal() - betValue);
                    return "You have " + myValue + " points. Your opponent has " + opponentValue + " points.\n You've won!\n" + endingResults + "\nYou've gained $" + betValue + "!";}
                    //return "You have " + a + " points. Your opponent has " + b + " points.\n You win!\nYou've gained " + this.opponentFinder().getBal() +"$!";
                 else if (myValue < opponentValue || myValue > 21 && opponentValue > 21) {
                   PanelVersion.UserBalance = PanelVersion.UserBalance-betValue;
                   AbstractCode.Opponent.setBal(Opponent.getBal() + betValue);
                   return "You have " + myValue + " points. Your opponent has " + opponentValue + " points.\n You lost!\nYou've lost " + betValue + "$!\n" + endingResults;}
                 else if ((myValue == opponentValue) && (myValue <= 21) && (opponentValue <= 21)) 
                    return "You have " + myValue + " points. Your opponent has " + opponentValue + " points.\n DRAW!\n" + endingResults;
                
            }
        } else if (gameHasStarted == true && Playermove == false && NPCmove == true && PlayerAction == false && NPCAction == true) {
            NPCmove = false;
            NPCAction = false;
            Playermove = true;
            infoSize = 1;
            return this.info(infoSize) + "\n(Press any key to continue)";
        }
        return "(Press enter again and press 1, 2, or 3 to make your next move. \nType 'make 11' to change one or more of your aces if you have one!)";
    }

    //Controls
    public void Hit(ArrayList<Card> c, String n) {

        PlayerHitAction = true;
        Card temp = CardDeck.get(0);
        CardDeck.remove(0);
        userInfo.add(temp);

    }

    public void Pass(ArrayList<Card> c, String n) {

        PlayerPassAction = true;
        Playermove = false;

    }

    public void Reveal(ArrayList<Card> c, String n) {

        PlayerRevealAction = true;

    }

    //Mini Methods
    public int chance() {
        int rando = (int) (Math.random() * 10);
        if (rando < 5) {
            return 0;
        } else {
            return 2;
        }
    }

    public boolean hasAce(ArrayList<Card> c) {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getType().equals("Ace")) {
                acePosition = i;
                c.get(i).setBool();
                return true;
            }
        }
        return false;
    }
    
    public void removeAce(ArrayList<Card> c) {
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getType().equals("Ace")) {
                c.remove(i);
            }
        }
    }

    public boolean listAccess(){
    boolean f = false;
    for(int i = 0; i < userInfo.size(); i++){
    if(userInfo.get(i).getnum() == 0)
        f = true;
    else
        f = false;
    }
    return f;
    }
    
    public void load(ArrayList<Card> c, int b) {
        for (int i = 0; i < 2; i++) {
            c.add(CardDeck.get(i + b));
            CardDeck.remove(i+b);
        }
        for(int i = 0; i < c.size(); i++){
        if(c.get(i).getType().equals("Ace")){
        userInfo.add(c.get(i));
        c.remove(i);
        }
        
        }
    }

    public String info(int i) {
        if (i == 0) {
            return "\nYour cards are:\n\n" + this.CardDisplay(userInfo) + "With your " + userInfo.get(0) + " Exposed!\nWhat do you do? (1 to Hit, 2 to Pass, 3 to Reveal, Type 'make 11' to change your ace)";
        } else if (i == 1) {
            return "Your opponent has " + npcInfo.size() + " cards.\nWith his " + npcInfo.get(0) + " Exposed!";
        } else if(i == 2){
            return "\nYou contain an ace(s) within your deck!\nWhat value would you like to set it to?\n(This is your card deck)\n" + CardDisplay(userInfo) + "With your " + userInfo.get(0) + "Exposed!\nEnter 'make 11' to change one of your aces to gain points!";
        }
        else {
            return "Not Supported";
        }
    }

    public NPCCode opponentFinder() {
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i).getBlackjackStatus() == true) {
                return Players.get(i);
            }
        }
        return null;
    }

  
    public int pointCompiler(ArrayList<Card> c) {
        int a = 0;
        for (int i = 0; i < c.size(); i++) {
            a += c.get(i).getnum();
        }
        return a;
    }

    public void pointAdder() {
        double i = (this.opponentFinder().getBal()) * .1;
        double l = this.opponentFinder().getBal();
        this.opponentFinder().setBal(l * .9);
        PanelVersion.BankBalance += i;

    }

    public void pointSubtractor() {
    }
    
    public void acePointer(ArrayList<Card> c, int f){
    for(int i = 0; i < c.size(); i++){
    if(c.get(i).getType().equals("Ace") && c.get(i).getnum() < 2){
    c.get(i).setnum(f);
    i = c.size();
    }
    }
    }
    
    //Test Methods
    public void printerMethod() {
        //System.out.println("Player Info: " + CardDisplay(userInfo));
        // System.out.println("NPC Info: " + CardDisplay(npcInfo));
        System.out.println("CardDeck Info: " + CardDisplay(CardDeck) + " " + CardDeck.toString());
    }

    public String CardDisplay(ArrayList<Card> c) {
        String n = "";
        for (int i = 0; i < c.size(); i++) {
            n += c.get(i) + "\n";
        }
        return n;
    }
    
    public void AceTester(){
        for(int i = 0; i < userInfo.size()-1; i++){
        if(!userInfo.get(i).getType().equals("Ace")){
        userInfo.remove(0);
        userInfo.add(new Card("Ace",1));
        }
        }
      
    }
}
