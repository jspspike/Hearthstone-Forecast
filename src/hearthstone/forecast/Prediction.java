/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hearthstone.forecast;

import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author johnson_849323
 */


public class Prediction {
    
    Card[][] disp;
    
    public Prediction() throws UnirestException{
        disp = new Card[10][8];
        
    }
}
