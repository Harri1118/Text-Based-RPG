/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.*;
import static java.awt.PageAttributes.MediaType.D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author harri
 */
public class iconGenerator extends JFrame{
JFrame f;
ImageIcon icon;   
  
    

  public void getFrame(){
   
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(400,400,400,400);
    icon = new ImageIcon("build/appIcon/appIconPic.jpg");
    setIconImage(icon.getImage());
    
    
   
    
}  

  
}

