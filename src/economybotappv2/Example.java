/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author harri
 */
public class Example {
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("How old are you? ");
	int age = input.nextInt();
	System.out.println("You are " + age + " years old! What's your name?");
	String name = input.next();
	System.out.println("Your name is " + name);
    }
}
