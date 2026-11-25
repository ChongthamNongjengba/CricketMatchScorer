import java.util.Comparator;

public class RunsComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p2.getRunsScored(), p1.getRunsScored());
    }
}