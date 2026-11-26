import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class PlayerRegistry {
    private HashSet<Player> registeredPlayers;
    private TreeSet<String> sortedNames;

    public PlayerRegistry() {
        this.registeredPlayers = new HashSet<>();
        this.sortedNames = new TreeSet<>();
    }

    public boolean registerPlayer(Player player) {
        for (Player p : registeredPlayers) {
            if (p.getName().equalsIgnoreCase(player.getName())) {
                return false;
            }
        }
        registeredPlayers.add(player);
        sortedNames.add(player.getName());
        return true;
    }

    public boolean removePlayerById(int playerId) {
        Iterator<Player> it = registeredPlayers.iterator();
        while (it.hasNext()) {
            Player p = it.next();
            if (p.getPlayerId() == playerId) {
                sortedNames.remove(p.getName());
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Player findPlayerByName(String name) {
        for (Player p : registeredPlayers) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public HashSet<Player> getAllPlayers() { return registeredPlayers; }
    public TreeSet<String> getSortedNames() { return sortedNames; }
    public int getTotalRegistered() { return registeredPlayers.size(); }
}