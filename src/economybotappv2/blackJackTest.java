/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import static economybotappv2.AbstractCode.Players;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author harri
 */
public class blackJackTest {
    public static boolean gameTime = false;    
    public static boolean gameHasStarted = false;
    public static boolean Playermove = false;
    public static boolean NPCmove = false;
    public static boolean PlayerAction = false;
    public static boolean NPCAction = false;

    public static boolean PlayerHitAction = false;
    public static boolean PlayerPassAction = false;
    public static boolean PlayerRevealAction = false;
    private static Deck Prep = new Deck();
    public static ArrayList<Card> CardDeck = new ArrayList<Card>();

    public String output = "";

    private NPCCode player;

    private static int c;
    private static int myValue = 0;
    private static int opponentValue = 0;

    public static int trueSize;
    
    private static ArrayList<Card> userInfo = new ArrayList<Card>();
    private static ArrayList<Card> npcInfo = new ArrayList<Card>();
    
    //Controls
    public static void load(ArrayList<Card> c, int b) {
        for (int i = 0; i < 2; i++) {
            c.add(CardDeck.get(i + b));
            // Prep.remove(i + b);
        }
    }
    
        //Mini Methods
    public static int chance() {
        int rando = (int) (Math.random() * 10);
        if (rando < 5) {
            return 0;
        } else {
            return 2;
        }
    }
    
    public static void reset() {
        gameHasStarted = false;
        Playermove = false;
        NPCmove = false;
        PlayerAction = false;
        NPCAction = false;
        PlayerHitAction = false;
        PlayerPassAction = false;
        PlayerRevealAction = false;
        myValue = 0;
        opponentValue = 0;
        Prep.clear(CardDeck);
    }
    
     public static  int pointCompiler(ArrayList<Card> c) {
        int a = 0;
        for (int i = 0; i < c.size(); i++) {
            a += c.get(i).getnum();
        }
        return a;
    }
     
    //Printer Methods
    public static String CardDisplay(ArrayList<Card> c) {
        String n = "";
        for (int i = 0; i < c.size(); i++) {
            n += c.get(i) + "\n";
        }
        return n;
    }
    
    public static String info(boolean c) {
        if (c == true) {
            System.out.println("Your cards are:\n" + blackJackTest.CardDisplay(userInfo) + "\nWith your " + userInfo.get(0) + " Exposed!\n Your opponent, " + NPCCode.name + ", has " + npcInfo.size() + " cards. With his\n" + npcInfo.get(0) + " Card exposed.\nWhat do you do? (1 to Hit, 2 to Pass, 3 to Reveal)");
        } else if (c == false) {
            return "Your opponent has " + npcInfo.size() + " cards.\nWith his " + npcInfo.get(0) + " Exposed!";
        } else {
            return "Not Supported";
        }
        return null;
    }
    
        //Controls
    public static void Hit(ArrayList<Card> c, String n) {

        PlayerHitAction = true;
        Card temp = CardDeck.get(0);
        CardDeck.remove(0);
        userInfo.add(temp);

    }

    public static void Pass(ArrayList<Card> c, String n) {

        PlayerPassAction = true;

    }

    public static void Reveal(ArrayList<Card> c, String n) {

        PlayerRevealAction = true;

    }
    
public static void printerMethod() {
        //System.out.println("Player Info: " + CardDisplay(userInfo));
        // System.out.println("NPC Info: " + CardDisplay(npcInfo));
        System.out.println("CardDeck Info: "+ CardDisplay(CardDeck));
    }
static BlackJack b = new BlackJack();
        public static void main(String[] args){
            boolean endGame = false;
            Scanner input = new Scanner(System.in);
            while(endGame == false){
            String s = input.nextLine();
            System.out.println(b.BlackJack(s));
            //if(b.)
            }
       
         /*
            Scanner input = new Scanner (System.in);
        if (gameHasStarted == false && Playermove == false && NPCmove == false && PlayerAction == false && NPCAction == false) {
            printerMethod();
            Prep.Deck(CardDeck);
            Prep.shuffle(CardDeck);
            c = blackJackTest.chance();
            //c = 2;
            blackJackTest.load(userInfo, c);
            blackJackTest.load(npcInfo, c);
            printerMethod();
            gameHasStarted = true;
            if (c == 2) {
                Playermove = true;
            } else {
                NPCmove = true;
            }
            System.out.println("\"Let's see who goes first...\\n(Press any button to continue)\"");
            String cont = input.nextLine();
            gameHasStarted = true;
        } else if (gameHasStarted == true && Playermove == true && NPCmove == false && PlayerAction == false && NPCAction == false) {
            PlayerAction = true;
            System.out.println(blackJackTest.info(true));
        } else if (gameHasStarted == true && Playermove == false && NPCmove == true && PlayerAction == false && NPCAction == false) {
            NPCAction = true;
            System.out.println("Your opponent, " + NPCCode.name + ", is making his move... \n(Press any button to continue)");
// return "Your opponent, " + NPCCode.name + ", has " + npcInfo.size() + " cards.";
        } else if (gameHasStarted == true && Playermove == true && NPCmove == false && PlayerAction == true && NPCAction == false) {
            System.out.println("What will be your next move?");
            String s = input.nextLine();
            if (s.equals("1")) {
                blackJackTest.Hit(userInfo, s);
            } else if (s.equals("2")) {
                blackJackTest.Pass(userInfo, s);
            } else if (s.equals("3")) {
                blackJackTest.Reveal(userInfo, s);
            }
            if (PlayerHitAction == true) {
                PlayerHitAction = false;
                PlayerAction = false;
                Playermove = false;
                NPCmove = true;
                blackJackTest.printerMethod();
                System.out.println("You've recieved a card! (Press any key to continue)");
                String f = input.nextLine();
            } else if (PlayerPassAction == true) {
                PlayerPassAction = false;
                PlayerAction = false;
                NPCmove = true;
                System.out.println("You passed your turn! (Press any key to continue)");
            } else if (PlayerRevealAction == true) {
                PlayerRevealAction = false;
                myValue = blackJackTest.pointCompiler(userInfo);
                opponentValue = blackJackTest.pointCompiler(npcInfo);
                if (myValue > opponentValue) {
                    int a = myValue;
                    int b = opponentValue;
                    blackJackTest.reset();
                    gameTime = false;
                    System.out.println("WIN");
                    //return "You have " + a + " points. Your opponent has " + b + " points.\n You win!\nYou've gained " + this.opponentFinder().getBal() +"$!";
                } else if (myValue < opponentValue) {
                    int a = myValue;
                    int b = opponentValue;
                    trueSize = CardDeck.size() - (userInfo.size() + npcInfo.size());
                    blackJackTest.reset();
                    gameTime = false;
                    System.out.println("You have " + a + " points. Your opponent has " + b + " points.\n You lost!\nYou've lost " + "$!");
                } else if (myValue == opponentValue) {
                    int a = myValue;
                    int b = opponentValue;
                    blackJackTest.reset();
                    gameHasStarted = true;
                    System.out.println("You have " + a + " points. Your opponent has " + b + " points.\n DRAW!");
                }
                // return "You have " + myValue + " points. Your opponent has " + opponentValue + " points.";
            } else {
                System.out.println("Impossible");
            }
        } else if (gameHasStarted == true && Playermove == false && NPCmove == true && PlayerAction == false && NPCAction == true) {
            NPCmove = false;
            NPCAction = false;
            Playermove = true;
            System.out.println(blackJackTest.info(false) + "\n(Press any key to continue)");
        }
*/       
    }
   

        }






    

    /*
  public NPCCode opponentFinder(){
        for(int i = 0; i < Players.size(); i++){
        if(Players.get(i).getBlackjackStatus() == true){
        return Players.get(i);
        }
        }
        return null;
}
  /*  
    }*/
/*
   
*/
  /*  
    public void pointAdder(){
    double i = (this.opponentFinder().getBal()) * .1;
    double l = this.opponentFinder().getBal();
    this.opponentFinder().setBal(l*.9);
    PanelVersion.BankBalance += i;
    
    }
*/
  //  public void pointSubtractor(){}
    //Test Methods
    
