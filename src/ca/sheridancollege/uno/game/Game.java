package ca.sheridancollege.uno.game;

import ca.sheridancollege.uno.player.Player;
import java.util.ArrayList;

public abstract class Game {
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public abstract void startGame();
}
