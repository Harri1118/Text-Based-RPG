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
public class GunItem extends Items{
    
    public GunItem(String s) {
        super(s);
        s.toLowerCase();
        if(s.equals("pistol")){
        cost = 500;
        }
        else if(s.equals("rifle")){
        cost = 1000;
        }
        else if(s.equals("Shotgun")){
        cost = 2000;
        }
    }
    
}
