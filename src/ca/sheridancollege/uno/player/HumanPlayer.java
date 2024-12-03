package ca.sheridancollege.uno.player;

import ca.sheridancollege.uno.model.Card;
import ca.sheridancollege.uno.model.Deck;
import java.util.List;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void playTurn(Card topCard, Deck deck) {
        System.out.println("Your turn, " + getName() + "!");
        System.out.println("Top card: " + topCard);
        System.out.println("Your hand: ");
        for (int i = 0; i < getHand().size(); i++) {
            System.out.println(i + ": " + getHand().get(i));
        }
        System.out.println("Enter the index of the card to play, or -1 to draw: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == -1) {
            Card drawnCard = deck.drawCard();
            if (drawnCard != null) {
                System.out.println("You drew: " + drawnCard);
                addCard(drawnCard);
            } else {
                System.out.println("No cards left to draw.");
            }
        } else if (choice >= 0 && choice < getHand().size()) {
            Card selectedCard = getHand().get(choice);
            if (selectedCard.isPlayable(topCard)) {
                playCard(choice, deck);
            } else {
                System.out.println("Invalid card. Please try again.");
                playTurn(topCard, deck);
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
            playTurn(topCard, deck);
        }
    }
    
    public List<Card> getHand() {
        return hand;
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    
    public void playCard(int index, Deck deck) {
        Card playedCard = hand.remove(index); // Remove card from hand
        deck.addToDiscardPile(playedCard); // Add card to the discard pile in the deck
    }
}
