package asign1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by hampus on 2016-09-09.
 */
public class Deck {
    ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();

        for (Card.Suite suite : Card.Suite.values()) {
            for (Card.RankValue rankValue : Card.RankValue.values()) {
                Card card = new Card(suite, rankValue);
                deck.add(card);
            }
        }
        this.shuffle();
    }

    public void shuffle(){
        if (this.deckSize() == 52) {
            Collections.shuffle(this.deck, new Random());
        }
        else {
            System.out.println("Shuffle just posible when you have 52 cards in the deck");
        }

    }

    public Card handOutNextCard(){
        Card nextCard  = deck.get(0);
        deck.remove(0);
        return nextCard;
    }

    public int deckSize(){
        return deck.size();
    }




}
