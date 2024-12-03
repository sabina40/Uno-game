package ca.sheridancollege.uno.game;

import ca.sheridancollege.uno.model.Card;
import ca.sheridancollege.uno.model.Deck;
import ca.sheridancollege.uno.player.Player;

import java.util.ArrayList;

public class GameController {
    private final ArrayList<Player> players;
    private final Deck deck;
    private Card topCard;
    private int currentPlayerIndex;
    private boolean isReverse;

    public GameController(ArrayList<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.isReverse = false;
        this.currentPlayerIndex = 0;

        // Deal 7 cards to each player
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }

        // Draw the initial top card
        this.topCard = deck.drawCard();
    }

    public void startGame() {
        System.out.println("Starting UNO game!");
        System.out.println("Initial top card: " + topCard);

        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer.getName() + "'s turn!");
            System.out.println("Top card: " + topCard);

            showCardCounts();

            // Player takes their turn
            currentPlayer.playTurn(topCard, deck);

            // Ensure the player did not draw from an empty deck
            if (deck.isEmpty()) {
                System.out.println("Deck is empty. Reshuffling...");
                reshuffleDeck();
            }

            if (currentPlayer.hasWon()) {
                System.out.println("\n" + currentPlayer.getName() + " wins the game!");
                break;
            }

            updateGameState();
        }
    }

    private void showCardCounts() {
        for (Player player : players) {
            if (!player.equals(players.get(0))) { // Only show bot card counts
                System.out.println(player.getName() + " has " + player.getHandSize() + " cards.");
            }
        }
    }

    private void updateGameState() {
        // Handle special cards like "Skip," "Reverse," or "Draw Two" if necessary
        if (topCard instanceof ca.sheridancollege.uno.model.SpecialCard) {
            String action = ((ca.sheridancollege.uno.model.SpecialCard) topCard).getAction();
            switch (action) {
                case "Skip":
                    System.out.println("Next player is skipped!");
                    moveToNextPlayer();
                    break;

                case "Reverse":
                    System.out.println("Game direction reversed!");
                    isReverse = !isReverse;
                    break;

                case "Draw Two":
                    System.out.println(players.get(nextPlayerIndex()) + " draws 2 cards!");
                    Player nextPlayer = players.get(nextPlayerIndex());
                    nextPlayer.drawCard(deck);
                    nextPlayer.drawCard(deck);
                    moveToNextPlayer(); // Skip their turn after drawing
                    break;

                default:
                    // No special action
                    break;
            }
        }

        moveToNextPlayer(); // Move to the next player
    }

    private void moveToNextPlayer() {
        if (isReverse) {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private int nextPlayerIndex() {
        if (isReverse) {
            return (currentPlayerIndex - 1 + players.size()) % players.size();
        } else {
            return (currentPlayerIndex + 1) % players.size();
        }
    }

    private void reshuffleDeck() {
        // Logic for reshuffling the deck from the discard pile (not implemented yet)
        // You can add logic here to gather discarded cards and shuffle them back into the deck
    }
}
