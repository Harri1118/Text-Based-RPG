/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package economybotappv2;

import static economybotappv2.AbstractCode.Opponent;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import static javax.swing.JSplitPane.RIGHT;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

/**
 *
 * @author Harri
 */
public class PanelVersion extends JFrame implements ActionListener {

    ImageIcon icon;
    Action enterKey;

    JSplitPane splitPane;
    JSplitPane rightDivide;

    JPanel display;
    JPanel userArea;
    JPanel consolePanel;
    JPanel inputArea;

    GridBagConstraints c;

    JTextArea console;
    JTextArea input;

    JScrollPane jsp;
    JScrollPane jsp2;

    JLabel DisplayedText;
    JLabel invis;

    public static TimerClass Timer;

    JButton Start = new JButton("Start");
    public BlackJack b;
    public AbstractCode inputter;
    public static String UserName = "";
    public static String Occupation = "";
    public static double UserBalance = 0;
    public static double BankBalance = 0;
    public String userInput = "";
    public boolean isInitialized = false;
    public boolean StartButton = false;
    public boolean blackJackMode = false;
    public boolean initiateBlackJack = false;

    public PanelVersion() {

        icon = new ImageIcon("src/iconImage/appIconPic.jpg");
        setIconImage(icon.getImage());

        b = new BlackJack();
        inputter = new AbstractCode();
        enterKey = new EnterKey();

        splitPane = new JSplitPane();
        rightDivide = new JSplitPane();

        Timer = new TimerClass();

        display = new JPanel();
        display.setLayout(new GridBagLayout());

        c = new GridBagConstraints();

        DisplayedText = new JLabel("<html>Name: " + UserName + "<br/>Occupation: " + Occupation + "<br/>Balance: " + String.format("%.2f", UserBalance) + "$ <br/>Bank Balance: " + String.format("%.2f", BankBalance) + "$ <br/></html>");
        invis = new JLabel("");
        c.anchor = GridBagConstraints.LINE_START;

        c.gridx = 0;
        c.gridy = 0;
        display.add(Timer.t, c);

        c.gridx = 0;
        c.gridy = 1;
        display.add(DisplayedText, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weighty = 10;
        display.add(invis, c);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        userArea = new JPanel(new BorderLayout());

        consolePanel = new JPanel();
        console = new JTextArea();
        console.setEditable(false);
        console.append("Welcome! What's your name?\n");
        jsp = new JScrollPane(console, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        consolePanel.add(console);
        consolePanel.add(jsp);

        inputArea = new JPanel();
        input = new JTextArea();
        input.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterKey");
        input.getActionMap().put("enterKey", enterKey);
        input.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            }
        });
        jsp2 = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inputArea.add(input);
        inputArea.add(jsp2);

        userArea.add(console);
        Start.addActionListener(this);
        inputArea.add(Start);
        Start.setAlignmentX(200);

        setPreferredSize(new Dimension(500, 500));

        getContentPane().setLayout(new GridLayout());
        getContentPane().add(splitPane);
        getContentPane().add(rightDivide);

        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(250);

        rightDivide.setOrientation(JSplitPane.VERTICAL_SPLIT);
        rightDivide.setDividerLocation(350);

        jsp.setViewportView(console);
        jsp2.setViewportView(input);

        splitPane.setTopComponent(display);
        splitPane.setBottomComponent(userArea);

        userArea.setLayout(new BoxLayout(userArea, BoxLayout.X_AXIS));

        rightDivide.setTopComponent(consolePanel);
        consolePanel.setLayout(new BoxLayout(consolePanel, BoxLayout.Y_AXIS));
        rightDivide.setBottomComponent(inputArea);
        inputArea.setLayout(new BoxLayout(inputArea, BoxLayout.Y_AXIS));

        userArea.setSize(500, 500);
        userArea.setVisible(true);

        setSize(650, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (StartButton == false && isInitialized == false && AbstractCode.blackJackTest == false && initiateBlackJack == false) {
            console.append("You must enter your name in order to start!");

        } else if (StartButton == false && isInitialized == true && blackJackMode == false) {
            Timer.start();
            StartButton = true;
            Start.setText("Stop");
        } else if (StartButton == true) {
            console.append("Already initiated");
        }
    }

    public class EnterKey extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) throws NumberFormatException{

            userInput = input.getText();
            if (isInitialized == false && AbstractCode.blackJackTest == false && initiateBlackJack == false) {
                console.append(userInput + "\n");
                UserName = userInput;

                DisplayedText.setText("<html>Name: " + UserName + "<br/>Occupation: " + Occupation + "<br/>Balance: " + String.format("%.2f", UserBalance) + "$ <br/>Bank Balance: " + String.format("%.2f", BankBalance) + "$ <br/></html>");

                if (UserName.equals(userInput)) {
                    console.append("Welcome " + UserName + "! Press the start button next to input box! \n");
                    userInput = "";
                    input.setText("");
                    if (StartButton == true) {

                        isInitialized = true;
                        userInput = "";
                        input.setText("");
                    }
                }

                isInitialized = true;
                userInput = "";
                input.setText("");
            } else if (isInitialized == true && AbstractCode.blackJackTest == false && initiateBlackJack == false && UserName.equals("tester")) {
                AbstractCode.blackJackTest = true;
                initiateBlackJack = true;
                userInput = "blackjack " + AbstractCode.Opponent.name;
            } else if (isInitialized == true && AbstractCode.blackJackTest == false && initiateBlackJack == false) {

                console.append(userInput + "\n");
                console.append(inputter.AbstractCode(userInput));
                if (inputter.AbstractCode(userInput).equals("")) {
                    console.append(null);
                }
                UserBalance = inputter.TempBalance;
                BankBalance = inputter.BankBalance;
                DisplayedText.setText("<html>Name: " + UserName + "<br/>Occupation: " + Occupation + "<br/>Balance: " + String.format("%.2f", UserBalance) + "$ <br/>Bank Balance: " + String.format("%.2f", BankBalance) + "$ <br/></html>");

            } else if (isInitialized == true && AbstractCode.blackJackTest == true && initiateBlackJack == false) {
                
                try{
                    BlackJack.betValue = Double.parseDouble(userInput);
                    console.append("The goal is to get your cards to 21...\n(Press any button to continue)");
                    
                    Timer.pause();
                    b.gameTime = true;
                    initiateBlackJack = true;}
                catch(Exception er){
                console.append("You've entered an invalid money value! Please try again!");
                }
            } else if (isInitialized == true && AbstractCode.blackJackTest == true && initiateBlackJack == true) {
                if (b.gameTime == false) {
                    AbstractCode.blackJackTest = false;
                    initiateBlackJack = false;
                    BlackJack c = new BlackJack();
                    b = c;
                    Timer.resume();
                }
                else{
                console.append(userInput + "\n");
                console.append(b.BlackJack(userInput));
                }
            }
            userInput = "";
            input.setText("");
        }

    }

}
