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


public final class Prediction {
    
    private ArrayList<Card> played;
    Card[][] disp;
    private final ArrayList<Deck> decks = new ArrayList<>();
    
    public Prediction() throws UnirestException{
        disp = new Card[8][10];
        addDecks();
    }
    
    public Prediction(ArrayList<Card> played) throws UnirestException {
        disp = new Card[8][10];
        addDecks();
        updatePlayed(played);
    }
    
    public Card[][] getCards() {
        return disp;
    }
    
    public void updatePlayed(ArrayList<Card> played) throws UnirestException {
        this.played = played;
        updateFreq();
    }
    
    private void addDecks() throws UnirestException {
        decks.add(new Deck("Mage-Spring-ESL"));
        decks.add(new Deck("Legend-Warsong"));
        decks.add(new Deck("Miracle-Rouge"));
        decks.add(new Deck("Default-Mage"));
    }
    
    private void updateFreq() throws UnirestException {
        Deck most = new Deck("");
        for (Deck deck : decks) {
            if (deck.getScore(played) > most.getScore(played)) {
                most = new Deck(deck);       
            }   
        }

        System.out.println("Cards " + most);
        for (int i = most.cards.size() - 1; i > 0; i--) {
            for (int j = 0; j < played.size(); j++) {
                if (most.cards.get(i).ID.equals(played.get(j).ID) && most.cards.get(i).frequncy == 1) {
                    most.cards.remove(i);
                    break;
                }
            }
        }
        
        for (int i = 0; i < disp.length; i++) {
            for (int j = 0; j < disp[i].length; j++) {
                for (int k = most.cards.size() - 1; k > 0; k--) {
                    if (most.cards.get(k).getMana() > 7 && i == 7)
                    {
                        disp[i][j] = most.cards.get(k);
                        most.cards.remove(k);
                        break;
                    }
                    if(most.cards.get(k).getMana() == i) {
                        disp[i][j] = most.cards.get(k);
                        most.cards.remove(k);
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < disp.length; i++) {
            for (int j = 0; j < disp[i].length; j++) {
                if (disp[i][j] == null)
                    output+= " blank " + " | ";
                else
                    output += disp[i][j].getName() + " | ";
            }
            output += "\n";
        }
        
        
        return output;
    }
}
