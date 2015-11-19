/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hearthstone.forecast;

import com.mashape.unirest.http.exceptions.UnirestException;

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
        Card card = new Card("GVG_110", 1);
        System.out.println(card.getName());
        System.out.println(card.getImage());
    }
    
}
