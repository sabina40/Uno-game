package ca.sheridancollege.uno.player;

import ca.sheridancollege.uno.model.Card;
import ca.sheridancollege.uno.model.Deck;
import java.util.ArrayList;

public abstract class Player {
    private final String name;
    protected final ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.size();
    }

    public void drawCard(Deck deck) {
        hand.add(deck.drawCard());
    }

    public abstract void playTurn(Card topCard, Deck deck);

    public boolean hasWon() {
        return hand.isEmpty();
    }
}
