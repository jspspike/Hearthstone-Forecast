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
    private String name;
    private String imgLing;
    
    private int score;
    
    public Card(String id) {
        String ID = id;
        
    }
    
}
