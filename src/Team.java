import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Team {
    public static final int MAX_PLAYERS = 11;

    private String teamName;
    private ArrayList<Player> players;
    private Queue<Player> battingOrder;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        this.battingOrder = new LinkedList<>();
    }

    public void addPlayer(Player player) throws TeamFullException {
        if (players.size() >= MAX_PLAYERS) {
            throw new TeamFullException("Team " + teamName + " already has " + MAX_PLAYERS + " players.");
        }
        players.add(player);
        battingOrder.offer(player);
    }

    public Player getNextBatter() {
        return battingOrder.poll();
    }

    public int getTotalRuns() {
        int total = 0;
        for (Player p : players) {
            total += p.getRunsScored();
        }
        return total;
    }

    public int getTotalWicketsLost() {
        int wickets = 0;
        for (Player p : players) {
            if (p.isOut()) {
                wickets++;
            }
        }
        return wickets;
    }

    public String getTeamName() { return teamName; }
    public ArrayList<Player> getPlayers() { return players; }
    public Queue<Player> getBattingOrder() { return battingOrder; }
    public int getPlayerCount() { return players.size(); }

    @Override
    public String toString() {
        return teamName + " - " + getTotalRuns() + "/" + getTotalWicketsLost()
                + " (" + players.size() + " players)";
    }
}