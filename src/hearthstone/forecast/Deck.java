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
 * @author johnson_849323
 */



public class Deck {
    ArrayList<Card> cards = new ArrayList<>();
    String name;
    int popularity;
    int totalscore = 0;
    
    
    public Deck(String name) throws UnirestException {
        this.name = name;
        
        if (name.equals("Mage-Spring-ESL")) {
            popularity = 5;
            cards.add(new Card("CS2_031", 2));
            cards.add(new Card("EX1_012", 1));
            cards.add(new Card("NEW1_021", 2));
            cards.add(new Card("CS2_024", 2));
            cards.add(new Card("EX1_096", 1));
            cards.add(new Card("FP1_004", 2));
            cards.add(new Card("EX1_007", 2));
            cards.add(new Card("CS2_023", 2));
            cards.add(new Card("CS2_026", 2));
            cards.add(new Card("EX1_289", 1));
            cards.add(new Card("EX1_295", 2));
            cards.add(new Card("EX1_275", 2));
            cards.add(new Card("CS2_029", 2));
            cards.add(new Card("GVG_069", 1));
            cards.add(new Card("CS2_028", 1));
            cards.add(new Card("BRM_028", 1));
            cards.add(new Card("EX1_559", 1));
            cards.add(new Card("CS2_032", 1));
            cards.add(new Card("EX1_561", 1));
            cards.add(new Card("EX1_279", 1));
        }
    }
    
    
    public int getScore(Card[] played) {
        return 0;
    }
}
