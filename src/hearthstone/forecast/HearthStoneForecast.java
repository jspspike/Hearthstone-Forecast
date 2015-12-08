/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hearthstone.forecast;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;

/**
 *
 * @author johnson_849323, Bates_844187
 */
public class HearthStoneForecast {

    /**
     * @param args the command line arguments
     * @throws com.mashape.unirest.http.exceptions.UnirestException
     */
    public static void main(String[] args) throws UnirestException {
        // TODO code application logic here
        long start = System.nanoTime();
        ArrayList<Card> swag = new ArrayList<>();
        swag.add(new Card("CS2_031", 1));
        swag.add(new Card("EX1_012", 1));
        
        
        Prediction predict = new Prediction(swag);
        
        System.out.println(predict);
        long end = System.nanoTime();
        System.out.println("Time elapsed: " + (((double)(end - start))/1000000000));
        
    }
    
}
