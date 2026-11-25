import java.util.Comparator;

public class EconomyComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        // Players who haven't bowled go to the bottom
        if (p1.getBallsBowled() == 0 && p2.getBallsBowled() == 0) return 0;
        if (p1.getBallsBowled() == 0) return 1;
        if (p2.getBallsBowled() == 0) return -1;

        // Lower economy rate is better in cricket
        return Double.compare(p1.getEconomyRate(), p2.getEconomyRate());
    }
}