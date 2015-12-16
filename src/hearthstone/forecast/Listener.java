/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hearthstone.forecast;

import com.mashape.unirest.http.exceptions.UnirestException;
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
    
    public ArrayList<Card> getNewPlayed() throws FileNotFoundException, UnirestException{
        ArrayList<Card> played = new ArrayList<>();
        
        Scanner log = new Scanner(new File(path));
        
        while(log.hasNext()) {
            String line = log.nextLine();
            int sIndex;
            int eIndex;
            
            for (int i = 0; i < line.length(); i++) {
                
                sIndex = 0;
                eIndex = 0;
                
                if (line.substring(i, i + 7).equals("cardId=")) {
                    sIndex = i + 7;
                }
                
                if (line.substring(i, i + 5).equals("playe")) {
                    eIndex = i;
                }
                
                if (eIndex != 0)
                    played.add(new Card(line.substring(sIndex, eIndex), 1));
            }
        }
        
        return played;
    }
}
