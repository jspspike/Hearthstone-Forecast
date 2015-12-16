/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hearthstone.forecast;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
/**
 *
 * @author johnson_849323
 */
public class Card {
    private final String name; //Name of the Card
    private final String imgLink; //Link to the Card Image
    int frequncy; //How often the card is played
    int cost; //The mana cost of the card
    String ID; //The Hearthstone ID of the card
    
    //Constructor taht takes the string ID 
    public Card(String id, int frequency) throws UnirestException {
        ID = id;
        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/" + ID)
        .header("X-Mashape-Key", "zjUPjPL76tmshBXkcxSXjbR1aabap15qjDgjsn7imXJUvuayT2")
        .header("Accept", "application/json")
        .asJson();
        

        String data = response.getBody().toString();
        int sindex = 0;
        int eindex = 0;


        for (int i = 0; i < data.length() - 9; i++) {
            if (data.substring(i, i + 6).equals(",\"name")) {
                sindex = i + 9;
            }
            
            if (data.substring(i, i + 5).equals(",\"img")) {
                eindex = i - 1;
            }
        }
         
        name = data.substring(sindex, eindex);
        
        sindex = 0;
        eindex = 0;
        
        for (int i = 0; i < data.length() - 7; i++) {
            if (data.substring(i, i + 6).equals("img\":\"")) {
                sindex = i + 6;
            }
            
            if (data.substring(i, i + 6).equals(",\"cost")) {
                eindex = i - 1;
            }
        }
        
        imgLink = data.substring (sindex, eindex);
        
        sindex = 0;
        eindex = 0;
        
        for (int i = 0; i < data.length() - 8; i++) {
            if (data.substring(i, i + 6).equals("cost\":")) {
                sindex = i + 6;
            }
            
            if (data.substring(i, i + 9).equals(",\"collect")) {
                eindex = i;
            }
        }
        
        cost = new Integer(data.substring(sindex, eindex));
        
        this.frequncy = frequency;
    }
    
    public String getName() {
        return name;
    }
    
    public int getMana() {
        return cost;
    }
    
    public String getImage() {
        return imgLink;
    }
    
    public int getFreq() {
        return frequncy;
    }
    
    public String getID() {
        return ID;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
