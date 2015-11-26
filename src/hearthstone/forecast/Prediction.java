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


public class Prediction {
    
    Card[] played;
    Card[][] disp;
    ArrayList<Deck> decks = new ArrayList<>();
    
    public Prediction() throws UnirestException{
        disp = new Card[10][8];
        addDecks();
        
        
    }
    
    private void addDecks() throws UnirestException {
        decks.add(new Deck("Mage-Spring-ESL"));
    }
    
    public void updateFreq() throws UnirestException {
        Deck most = new Deck("");
        for (Deck deck : decks) {
            if (deck.getScore(played) > most.getScore(played)) {
                most = deck;
            }
        }
        
        for (int i = 0; i < disp.length; i++) {
            for (int j = 0; j < disp[i].length; j++) {
                for (int k = most.cards.size(); k > 0; k--) {
                    if (most.cards.get(k).getMana() == i + 1) {
                        disp[i][j] = most.cards.get(k);
                        most.cards.remove(k);
                    }
                }
            }
        }
    }
}
