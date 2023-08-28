import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.util.*;


/**
*
* @author Srikarran Sowrirajan
*/
public class Board extends javax.swing.JFrame  {  //javax.swing.ActionListener {
   
   private JFrame mainFrame;
   public static JPanel jPanel1 , jPanel2;
   public static LinkedList listNew;
   public static JButton jBut1;
   private static final long serialVersionUID = 1L; ;
   public static GameTree game;

   
   private JLabel headerLabel;
   
   public Board (){
       
       mainFrame = new JFrame("8 Puzzle");
       mainFrame.setSize(280,280);
       mainFrame.setLayout(new BorderLayout() );  
       headerLabel = new JLabel("",JLabel.CENTER );
       
       
       jPanel1 = new JPanel(new GridLayout(1,1));
       jPanel1.setSize(60, 60);
       
       jPanel2 = new JPanel(new GridLayout(3,3));
       jPanel2.setSize(180, 180);
       
       Container c = this.getContentPane();
       c.add(this.jPanel1, "Center");

       
       jBut1 = new JButton();    
           
       
       jBut1.setText("Start");
       jBut1.setSize(50, 100);
       
       
       
       c.add(this.jBut1, "West");
       //this.pack();
       
       game = new GameTree();
           
       jBut1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jBut1ActionPerformed(evt);
           }
       }); 
               
       try {
       UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
       }
       catch (Exception e) {
       }   
       
       jPanel1.add(jBut1);
       
       mainFrame.add(jPanel1, BorderLayout.NORTH);
       mainFrame.add(jPanel2, BorderLayout.SOUTH);
       mainFrame.add(headerLabel);
       
       
       //mainFrame.pack();
       mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       mainFrame.setVisible(true);

       
   }

       private static void jBut1ActionPerformed(java.awt.event.ActionEvent evt) {

           
           int [] Array =  game.getList().getNode().getArray();
           game.percolate();
           
           jPanel2.setLayout(new GridLayout(3, 3));
           
           jPanel2.removeAll();
           
           
           jBut1.setText("Next Move");

           JButton button1;
           int number = 0;

           for (int i = 1; i <= 3; i ++) {
               for (int j = 1; j <= 3; j ++) {

                   button1 = new JButton();
                   button1.setPreferredSize(new Dimension(60, 60));
                   jPanel2.add(button1);
                   button1.setText(Integer.toString(Array[number]));

                   number ++;

               }
           }
           
           jPanel2.revalidate();
           jPanel2.repaint();
       }

   public static void main(String args[]) {
       
       Board board = new Board();

       
   }
}
