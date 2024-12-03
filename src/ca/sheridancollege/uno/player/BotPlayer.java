package ca.sheridancollege.uno.player;

import ca.sheridancollege.uno.model.Card;
import ca.sheridancollege.uno.model.Deck;

public class BotPlayer extends Player {
    public BotPlayer(String name) {
        super(name);
    }

    public void playTurn(Card topCard, Deck deck) {
        System.out.println("\n" + getName() + "'s turn!");

        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).matches(topCard)) {
                Card playedCard = hand.remove(i);
                System.out.println(getName() + " played: " + playedCard);
                return;
            }
        }

        drawCard(deck);
        System.out.println(getName() + " drew a card.");
    }
}
