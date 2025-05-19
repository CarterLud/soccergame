package Player;

import java.util.ArrayList;

public class PlayerManager{
    public static ArrayList<Player> players = new ArrayList<Player>();
    public Player player;

    public PlayerManager(Player currentPlayer) {
        this.player = currentPlayer;
        players.add(currentPlayer);
    }

}
