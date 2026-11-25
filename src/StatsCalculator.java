import java.util.ArrayList;
import java.util.TreeMap;

public class StatsCalculator {

    public double calculateCurrentRunRate(int totalRuns, int totalLegalBalls) {
        if (totalLegalBalls == 0) {
            return 0.0;
        }
        double overs = totalLegalBalls / 6.0;
        double rate = totalRuns / overs;
        return Double.valueOf(Math.round(rate * 100.0) / 100.0);
    }

    public double calculateRequiredRunRate(int targetRuns, int currentRuns, int remainingBalls) {
        int runsNeeded = targetRuns - currentRuns;
        if (runsNeeded <= 0) {
            return 0.0;
        }
        if (remainingBalls <= 0) {
            return Double.POSITIVE_INFINITY;
        }
        double remainingOvers = remainingBalls / 6.0;
        double reqRate = runsNeeded / remainingOvers;
        return Double.valueOf(Math.round(reqRate * 100.0) / 100.0);
    }

    public TreeMap<Integer, Double> getOverByOverRunRate(ArrayList<Over> overs) {
        TreeMap<Integer, Double> runRateProgression = new TreeMap<>();
        int cumulativeRuns = 0;
        int cumulativeBalls = 0;

        for (Over over : overs) {
            cumulativeRuns += over.getRunsConceded();
            cumulativeBalls += over.getLegalBalls();
            double crr = calculateCurrentRunRate(cumulativeRuns, cumulativeBalls);
            runRateProgression.put(over.getOverNumber(), crr);
        }
        return runRateProgression;
    }
}
