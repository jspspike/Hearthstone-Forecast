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
    private final String name;
    private final String imgLink;
    int frequncy;
    
    
    public Card(String id, int frequency) throws UnirestException {
        String ID = id;
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
        this.frequncy = frequency;
    }
    
    public String getName() {
        return name;
    }
    
    public String getImage() {
        return imgLink;
    }
}
