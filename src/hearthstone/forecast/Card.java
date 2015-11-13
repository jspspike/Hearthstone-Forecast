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
import java.util.Scanner;
/**
 *
 * @author johnson_849323
 */
public class Card {
    private String name;
    private String imgLing;
    
    private int score;
    
    public Card(String id) throws UnirestException {
        String ID = id;
        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/" + ID)
        .header("X-Mashape-Key", "zjUPjPL76tmshBXkcxSXjbR1aabap15qjDgjsn7imXJUvuayT2")
        .header("Accept", "application/json")
        .asJson();
        

        String data = response.getBody().toString();
        int sindex = 0;
        int eindex = 0;
        
        for (int i = 0; i < data.length(); i++) {
            if (data.substring(i, i + 6).equals(",/name")) {
                sindex = i + 9;
            }
            
            if (data.substring(i, i + 5).equals(",/img")) {
                eindex = i - 1;
            }
        }
        
        name = data.substring(sindex, eindex);
        
    }
    
    public String getName() {
        return name;
    }
    
}
