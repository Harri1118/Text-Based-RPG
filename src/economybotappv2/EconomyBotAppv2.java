/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;



public class EconomyBotAppv2 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
     
       // new iconGenerator().getFrame();
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
          
            
                new PanelVersion().setVisible(true);
            }

        });
    }
}
