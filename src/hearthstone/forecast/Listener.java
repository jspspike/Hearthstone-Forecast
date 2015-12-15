/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hearthstone.forecast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author johnson_849323
 */
public class Listener {
    String path;
    
    public Listener(String path) {
        this.path = path;
    }
    
    public ArrayList<Card> getNewPlayed() throws FileNotFoundException{
        ArrayList<Card> played = new ArrayList<>();
        
        Scanner log = new Scanner(new File(path));
        
        while(log.hasNext()) {
            String line = log.nextLine();
            String sIndex;
            String eIndex;
            
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i + 7).equals("cardId=")) {
                    
                }
            }
        }
        
        return played;
    }
}
