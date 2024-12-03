package ca.sheridancollege.uno.model;

import java.util.ArrayList;
import java.util.Collections;

public final class Deck {
    private final ArrayList<Card> cards;
    private final ArrayList<Card> discardPile;

    public Deck() {
        cards = new ArrayList<>();
        discardPile = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    public void initializeDeck() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        for (String color : colors) {
            for (int i = 0; i <= 9; i++) {
                cards.add(Card(color, ""));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }                                                       
                                                            

    public Card drawCard() {
        if (cards.isEmpty()) {
            reshuffle();
        }
        return cards.isEmpty() ? null : cards.remove(0);
    }

    public void addToDiscardPile(Card card) {
        discardPile.add(card);
    }

    private void reshuffle() {
        if (!discardPile.isEmpty()) {
            System.out.println("Reshuffling discard pile into the deck...");
            cards.addAll(discardPile);
            discardPile.clear();
            shuffle();
        }
    }
}
