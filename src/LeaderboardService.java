import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LeaderboardService {

    public ArrayList<Player> getTopRunScorers(ArrayList<Player> players, int topN) {
        ArrayList<Player> sortedList = new ArrayList<>(players);
        Collections.sort(sortedList, new RunsComparator());

        ArrayList<Player> topScorers = new ArrayList<>();
        Iterator<Player> iterator = sortedList.iterator();
        int count = 0;

        while (iterator.hasNext() && count < topN) {
            topScorers.add(iterator.next());
            count++;
        }
        return topScorers;
    }

    public ArrayList<Player> getBestBowlers(ArrayList<Player> players, int topN) {
        PriorityQueue<Player> pq = new PriorityQueue<>(new EconomyComparator());
        for (Player p : players) {
            if (p.getBallsBowled() > 0) {
                pq.offer(p);
            }
        }

        ArrayList<Player> topBowlers = new ArrayList<>();
        while (!pq.isEmpty() && topBowlers.size() < topN) {
            topBowlers.add(pq.poll());
        }
        return topBowlers;
    }
}