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
    
    
    public Deck(Deck deck) {
        deck.cards = this.cards;
        deck.popularity = this.popularity;
        deck.totalscore = this.totalscore;
        deck.name = this.name;
        
    }
    
    public Deck(String name) throws UnirestException {
        this.name = name;
        
        if (name.equals("")) {
            popularity = 0;
        }
        
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
        
        if (name.equals("Legend-Warsong")) {
            popularity = 8;
            cards.add(new Card("EX1_084", 1));
            cards.add(new Card("EX1_405", 1));
            cards.add(new Card("FP1_028", 1));
            cards.add(new Card("NEW1_016", 1));
            cards.add(new Card("EX1_100", 1));
            cards.add(new Card("EX1_055", 1));
            cards.add(new Card("EX1_616", 1));
            cards.add(new Card("NEW1_037", 1));
            cards.add(new Card("EX1_557", 1));
            cards.add(new Card("EX1_015", 1));
            cards.add(new Card("EX1_076", 1));
            cards.add(new Card("EX1_058", 1));
            cards.add(new Card("EX1_582", 1));
            cards.add(new Card("EX1_597", 1));
            cards.add(new Card("EX1_019", 1));
            cards.add(new Card("EX1_083", 1));
            cards.add(new Card("EX1_595", 1));
            cards.add(new Card("EX1_046", 1));
            cards.add(new Card("EX1_093", 1));
            cards.add(new Card("EX1_043", 1));
            cards.add(new Card("NEW1_024", 1));
            cards.add(new Card("EX1_116", 1));
            cards.add(new Card("EX1_067", 1));
            cards.add(new Card("EX1_095", 1));
            cards.add(new Card("EX1_112", 1));
            cards.add(new Card("EX1_614", 1));
            cards.add(new Card("EX1_016", 1));
            cards.add(new Card("CS2_222", 1));
            cards.add(new Card("EX1_105", 1));
            cards.add(new Card("EX1_620", 1));
        }
        
        if (name.equals("Miracle-Rouge")) {
            cards.add(new Card("EX1_012", 1));
            cards.add(new Card("GVG_110", 1));
            cards.add(new Card("FP1_030", 1));
            cards.add(new Card("EX1_016", 1));
            cards.add(new Card("EX1_005", 1));
            cards.add(new Card("EX1_284", 2));
            cards.add(new Card("EX1_093", 2));
            cards.add(new Card("FP1_007", 2));
            cards.add(new Card("EX1_134", 2));
            cards.add(new Card("FP1_012", 1));
            cards.add(new Card("LOE_019", 2));
            cards.add(new Card("CS2_188", 2));
            cards.add(new Card("EX1_096", 2));
            cards.add(new Card("FP1_002", 2));
            cards.add(new Card("GVG_096", 2));
            cards.add(new Card("EX1_124", 2));
            cards.add(new Card("EX1_129", 2));
            cards.add(new Card("CS2_072", 2));
        }
    }
    
    
    
    
    public int getScore(Card[] played) {
        for (int i = 0; i < played.length; i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (played[i].getID().equals(cards.get(j).getID())) {
                    totalscore += cards.get(i).getFreq();                  
                }
            }
        }
        
        totalscore *= popularity;
        return totalscore;
    }
}
