/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Harri
 */
public class TimerClass {

    public static int hour = 0;
    public static int day = 0;
    public static int realTime;
    
    public static boolean timerController = false;
    
    Timer timer = new Timer();
    
    JLabel t = new JLabel("<html><br/>Day " + day + ", hour " + hour + "<br/>");
    
    public static boolean daily = true;
    public TimerTask task = new TimerTask() {
        
        public void run() {
            if(timerController == false){
            tracker();
            t.setText("<html><br/>Day " + day + ", hour " + hour + "<br/>");
            System.out.println("Hour: " + hour + " Day: " + day + " Real time seconds " + realTime + " Seconds");}
        }
        
    };

    public void start() {

        timer.scheduleAtFixedRate(task, 1000, 1000);

    }   
    
    public void pause(){
    timerController = true;
    }
    
    public void resume(){
    timerController = false;
    }
    public void tracker(){
      
            realTime+=3;
            if(realTime % 30 == 0){
            hour++;
            }
            else if(realTime == 1200){
            realTime = 0;
            hour++;
            }
            if (hour == 24) {
                hour = 0;
                day++;
                daily = true;}
            
    }
}
    

