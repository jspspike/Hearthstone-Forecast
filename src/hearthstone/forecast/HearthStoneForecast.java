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
 * @author johnson_849323, Bates_844187
 */
public class HearthStoneForecast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnirestException {
        // TODO code application logic here
        HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/EX1_100")
            .header("X-Mashape-Key", "zjUPjPL76tmshBXkcxSXjbR1aabap15qjDgjsn7imXJUvuayT2")
            .header("Accept", "application/json")
            .asJson();
        
        System.out.println(response);
    }
    
}
