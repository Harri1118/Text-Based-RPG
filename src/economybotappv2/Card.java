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
public class Card {

    private String name;
    private String type;
    private int value;
    private boolean aceCalled = false;
    
    public Card(String n, int v) {
        name = n;
        value = v;
    }

    public Card(String n) {
        name = n;
    }

    public void setType(String n) {
        type = n;
    }

    public String toString() {
        return name + ", " + type + ", Value: " + value + "\n";
    }
    
    public void setnum(int i){
    value = i;
    }
    
    public int getnum() {
        return value;
    }
    public String getType(){
        return name;
    }
    public void setBool(){
        if(aceCalled == false)
            aceCalled = true;
        else
            aceCalled = false;
    }
    public boolean isCalled(){
            return aceCalled;}
}
