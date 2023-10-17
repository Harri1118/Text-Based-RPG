/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

//import java.util.Scanner;
import static economybotappv2.AbstractCode.PlayersInfo;
import java.util.ArrayList;

/**
 *
 * @author Harri
 */
public class AbstractCode {

    public static ArrayList<NPCCode> Players = new ArrayList<NPCCode>();
    public static String[] PlayersInfo;
    public static ArrayList<Items> Inventory = new ArrayList<Items>();

    public static int PlayerCount = 0;
    private double begCount = 0;

    public double TempBalance = 0;
    public double BankBalance = 0;
    public String input = "";
    public String output = "";

    public static boolean summonRanOnce = false;
    public static boolean summonQuestion = false;
    public static boolean blackJackTest = false;
    private boolean bet = false;
    public static boolean isPlayable = false;
    public static boolean ranOnceDeck = false;
    public static NPCCode Opponent;
    
    public ArrayList<Card> c = new ArrayList();
    public Deck t = new Deck();

    //Threader
    public String AbstractCode(String s) {
        s.toLowerCase();
        cheatGun(s);
        Money(s);
        deckTest(s);
        summon(s);
        blackjack(s);
        plsbeg(s);
        PlayerList(s);
        daily(s);
        bankrob(s);
        deposit(s);
        inventory(s);
        pause(s);
        resume(s);
        
       
        if (summonRanOnce == true) {
            String f = s.substring(7,s.length());
            Players.add(new NPCCode(f));
            summonRanOnce = false;
            PlayerCount++;
            isPlayable = true;
            return Players.get(PlayerCount - 1).toString();

        }

        String realOutput = output;
        output = "";
       if(realOutput.equals(""))
            realOutput = "Unknown command";
        
        return realOutput;
    }

    //Secondary Methods
    public boolean itemFound(String s) {
        for (int i = 0; i < Inventory.size(); i++) {
            if (Inventory.get(i).name.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public long randAmountBank() {
        long bankAmount = (long) (Math.random() * 10000000) + 1000000;
        Math.round(bankAmount);
        return bankAmount;
    }

    public boolean playerNameIsReal(String s) {
        for (int i = 0; i < Players.size(); i++) {
            if (s.equals(Players.get(i).name)) {
                Opponent = Players.get(i);
                return true;
            }
        }
        return false;
    }

    //Commands
    
    public void help(String s){
    if(s.equals("help")){
    
    }
    }
    
    public void bankrob(String s) {
        if (s.equals("bankrob") && itemFound("GunItem") == true && itemFound("MaskItem") == true) {
            double r = Math.random();
            if (Math.random() < .5) {
                output += "You have robbed a bank and have recieved " + randAmountBank() + "$ dollars!\n";
            } else {
                output += "You've been arrested for robbery!\n You must pay 500$ or else you die! (Type 'pay bail')";
            }
        }
    }

    public void inventory(String s) {
        if (s.equals("inv") || s.equals("inventory")) {
            String out = "";
            for (int i = 0; i < Inventory.size() - 1; i++) {
                out += Inventory.get(i).toString();

            }
            output = out;

        }
    }

    public void plsbeg(String s) {
        if (s.equals("beg") && (begCount % 10) == 0) {
            double hundreth = (int) (Math.random() * 10);
            double tenth = (int) (Math.random() * 10);
            int dol = (int) (Math.random() * 2);
            hundreth /= 100;
            tenth /= 10;
            double tot = dol + tenth + hundreth;
            TempBalance += tot;
            int randomChance = (int) (Math.random() * 10);
            begCount++;
            output += "You begged and recieved " + String.format("%.2f", tot) + "$!\n";
            if (tot == 0) {
                output += "You've recieved nothing!\n";
            }
        } else if (s.equals("beg") && !(begCount % 10 == 0)) {
            output += "You cannot beg! You must find a job!\n";
            begCount++;
        }
    }

    public void PlayerList(String s) {
        if (s.equals("list") && Players.size() >= 0) {
            output = Players.get(0).toString();
        }

    }

    public void daily(String s) {
        if (s.equals("daily") && TimerClass.daily == true) {
            TempBalance += (20 / 2);
            TimerClass.daily = false;
            output = "You've recieved your daily allouance!\n";
        }
    }

    public void summon(String s) {
       try{ if (s.contains("summon") && !(s.substring(7,s.length())).equals(PanelVersion.UserName) && s.length() > 7) {
            summonRanOnce = true;
        }
        else if(s.contains("summon") && s.substring(7,s.length()).equals(PanelVersion.UserName) && s.length() > 7){
            output = "You cannot summon yourself!";
        }}
       catch(Exception e){
       output = "Invalid usage of the Summon command!\nYou must use summon like this: 'summon ' + name of your opponent!";
       }
    }

    public void blackjack(String s) {
        if (s.contains("blackjack ") && isPlayable == true) {
            String nameStated = s.substring(10, s.length());
            if (playerNameIsReal(nameStated) == true) {
                blackJackTest = true;
                
                output = "You'll be playing against " + Opponent.name + ", how much money would you like to bet?\n";
            } else {
                output = "No one to play against!\n";
            }
        }

    }

    public void deposit(String s) {
        if (s.equals("deposit")) {
            BankBalance += TempBalance;
            TempBalance = 0;
        }
    }

    public void fish() {

    }

    public void gamble() {
    }

    public void gift() {
    }

    public void highlow() {
    }

    public void hunt() {
    }

    public void lootbox() {
    }

    public void lottery() {
    }

    public void monthly() {
    }

    public void multiplier() {
    }

    public void pet() {
    }

    public void postmemes() {
    }

    public void prestiege() {
    }

    public void remove() {
    }

    public void rich() {
    }

    public void search() {
    }

    public void sell() {
    }

    public void shop() {
    }

    public void buy(String s) {
        if (s.equals("buy")) {
        }
    }

    public void slots() {
    }

    public void snakeeyes() {
    }

    public void steal() {
    }

    public void use() {
    }

    public void withdraw(String s) {
        if (s.equals("withdraw ")) {
        }
    }

    public void work() {
    }

    //Cheats
    public void deckTest(String s) {
        if (s.equals("testdeck") && ranOnceDeck == false) {
            t.Deck(c);
            //t.removeHalf(c);
            System.out.println(t.toString(c));
            ranOnceDeck = true;
            output += "testdeck initiated\n";
        }
        if (s.equals("shuffle") && ranOnceDeck == false) {
            Deck t = new Deck();
            t.Deck(c);
            t.shuffle(c);
            System.out.println(t.toString(c));
            ranOnceDeck = true;
            output += "testdeck shuffle initiated\n";
        }
    }

    public void cheatGun(String s) {
        if (s.equals("gun")) {
            GunItem gun = new GunItem("Gun");
            Inventory.add(gun);
        }
    }

    public void Money(String s) {
        if (s.equals("m")) {
            TempBalance++;
            output += "You made a dollar!\n";
        }

    }
    
    public void pause(String s){
    if(s.equals("pause"))
        PanelVersion.Timer.pause();
    }
    
    public void resume(String s){
    if(s.equals("resume")){
        PanelVersion.Timer.resume();
    }
    }
}
