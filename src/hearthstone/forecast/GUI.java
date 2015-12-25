/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hearthstone.forecast;

import com.mashape.unirest.http.exceptions.UnirestException;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bates_844187
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    int height = 0;
    Image car;
    
        Prediction predict;
        ArrayList<Card> read = new ArrayList<>();
        Scanner IDs;
        //Creates a the mana Jpanels for horizontal organization
        JPanel[] manaP = new JPanel[9];
        //Creates the cards array to store all cards in a 2d array
        public static JLabel[][] cards = new JLabel[9][10];

    public GUI() throws IOException, UnirestException {

        
        //Creates a File Chooser and start a listener to read the file chosen
        JFileChooser kfc = new JFileChooser();

        if (kfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                    Listener listen = new Listener( "" + kfc.getCurrentDirectory());
                    System.out.println( "" + kfc.getCurrentDirectory());
        }
        
        
        initComponents();
        
        BufferedImage image = null;
        height = Main.getHeight();
        

        //Fills cards with Jlabels so they can be set later
        
        for(int i = 0; i < 9;i++){
            for(int h = 0; h < 10;h++){
                cards[i][h] = new JLabel();
                cards[i][h].setPreferredSize(new Dimension(50,50));
            }
        }
        
        
        //Creates the structure for the Mana Panels and sets their size
        for(int i = 0; i < 9;i++)
        {
            manaP[i] = new JPanel();
            manaP[i].setLayout(new BorderLayout());
            manaP[i].setPreferredSize(new Dimension(1080, 200));
            manaP[i].setVisible(true);
        }
        
        //Establishes the GridLayout horizontally and vertically
        GridLayout gridY = new GridLayout(9,1);
        GridLayout gridX = new GridLayout(1,10);
        //Main.setLayout(new BorderLayout());
        Main.setLayout(gridY);
        
        
        //Adds the mana value GUI elements manually 
        ImageIcon mana0 = new ImageIcon("assets/0.png");
        cards[0][0].setIcon(mana0);
        ImageIcon mana1 = new ImageIcon("assets/1.png");
        cards[1][0].setIcon(mana1);
        ImageIcon mana2 = new ImageIcon("assets/2.png");
        cards[2][0].setIcon(mana2);
        ImageIcon mana3 = new ImageIcon("assets/3.png");
        cards[3][0].setIcon(mana3);
        ImageIcon mana4 = new ImageIcon("assets/4.png");
        cards[4][0].setIcon(mana4);
        ImageIcon mana5 = new ImageIcon("assets/5.png");
        cards[5][0].setIcon(mana5);
        ImageIcon mana6 = new ImageIcon("assets/6.png");
        cards[6][0].setIcon(mana6);
        ImageIcon mana7 = new ImageIcon("assets/7.png");
        cards[7][0].setIcon(mana7);
        //ResizeSet("assets/1.png", cards[0][0], (int) (1 * 16 * (height / 100)), (int) (.66 * (1 * 16 * (height / 100))));
        
        //Adds all the cards to the layout along with mana panels
        for(int i = 0; i < 9;i++){        
            
            for(int h = 0; h < 10;h++){
               //manaP[i].add(cards[i][h]);
                manaP[i].setLayout(gridX);
                manaP[i].add(cards[i][h]);
                manaP[i].setBackground(new Color(209,185,131));
               //manaP[i].add(cards[i][h], BorderLayout.EAST);
               //System.out.print(manaP[i].getY());
            }
            
            Main.add(manaP[i], BorderLayout.SOUTH);
        }
        //manaP[0].setVisible(true);
        
  
        IDs = new Scanner(new File("cardIDs.txt"));
        System.out.println("Intialized!");
        
    }

    
    public void updateCards() throws UnirestException, IOException {
        
        //Grabs the url links from the predict class and resizes them to make them fit

        predict = new Prediction(read);
        
        while (IDs.hasNextLine()) {
            System.out.println("Adding Card");
                read.add(new Card(IDs.nextLine(), 1));                
            }
        
        
                
        System.out.println("Calculating");
        predict = new Prediction(read);
        
        System.out.println("Printing!" + predict);
        for(int i = 0; i < 8;i++)   {
                    for(int h = 0; h < 10;h++){
                        if(predict.disp[i][h] != null){
                            ResizeSet(predict.disp[i][h].getImage(), cards[i][h+1], (int) (1 * 15 * (height / 100)), (int) (.66 * (1 * 15 * (height / 100))));
                        }
                        System.out.println("Sizing" + i + "," + h);
                    }
                }
          }
    //Method to take a link in string form, the jLabel / card you want to change,  and the dimensions
	//It then puts it through the resize method that uses 2d graphics to re render the image

    public void ResizeSet(String link, JLabel label, int h, int w) throws MalformedURLException, IOException{
        URL url = new URL(link);
        BufferedImage image = ImageIO.read(url);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
        BufferedImage resizedImage = resize (image,w,h);
        resizedImage = resizedImage.getSubimage((int)(w * .05), (int)(h * .1), (int)(w * .9), (int)(h *.85));
        icon.setImage(resizedImage);
    }
    
//Component from the internet
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(209, 185, 131));

        Main.setBackground(new java.awt.Color(209, 185, 131));
        Main.setPreferredSize(new java.awt.Dimension(1080, 1080));

        javax.swing.GroupLayout MainLayout = new javax.swing.GroupLayout(Main);
        Main.setLayout(MainLayout);
        MainLayout.setHorizontalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        MainLayout.setVerticalGroup(
            MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Main, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                long start = System.nanoTime();
                try{
                    GUI a = new GUI();
                    new GUI().setVisible(true);
                }
                catch(IOException e){System.out.println(e);} catch (UnirestException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                        long end = System.nanoTime();
                        System.out.println("Time elapsed: " + (((double)(end - start))/1000000000));
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel Main;
    // End of variables declaration                   
}
