package ca.sheridancollege.uno.game;

import ca.sheridancollege.uno.player.BotPlayer;
import ca.sheridancollege.uno.player.HumanPlayer;
import ca.sheridancollege.uno.player.Player;

import java.util.ArrayList;

public class UnoGame {
    public static void main(String[] args) {
        System.out.println("Welcome to UNO!");

        ArrayList<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("You"));
        players.add(new BotPlayer("Bot 1"));
        players.add(new BotPlayer("Bot 2"));
        players.add(new BotPlayer("Bot 3"));

        GameController gameController = new GameController(players);
        gameController.startGame();
    }
}
