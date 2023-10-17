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
public class Items {
public String name;
public double cost;

public Items(String s){
name = s;
}

public String toString(){
return name + "\n";
}
}
