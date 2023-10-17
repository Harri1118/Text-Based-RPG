/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

/**
 *
 * @author Harri
 */
public class NPCCode {

    public static String name = "";
    private String Occupation = "";
    private double income = 0;
    private double tempBal = 100;
    private double bank = 100;
    private double netWorth = 0;
    
    private boolean opponent = false;
    
    public NPCCode(String s) {
        name = s;
    }

   
    @Override
    public String toString() {
        return "Name: " + name + "\nOccupation & Income: " + Occupation + "(" + income + "$)" +"\nBalance: " + tempBal + "\nBank: " + bank + "\nNet Worth: " + netWorth + "\n";
    }

    public void clear() {
        name = "";
    }
    public double getBal(){
    return tempBal;
    }
    public void setBal(double i){
    i = bank;
    }
    
    //Blackjack Method(s)
    public boolean getBlackjackStatus() {return opponent;}
    public void setBlackjackStatus(boolean h){opponent = h;}
}
