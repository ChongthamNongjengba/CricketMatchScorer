import java.util.ArrayList;

public class Innings {
    private String battingTeamName;
    private String bowlingTeamName;
    private int totalRuns;
    private int wicketsLost;
    private ArrayList<Over> overs;
    private int targetRuns; // -1 for 1st innings

    public Innings(String battingTeamName, String bowlingTeamName, int targetRuns) {
        this.battingTeamName = battingTeamName;
        this.bowlingTeamName = bowlingTeamName;
        this.totalRuns = 0;
        this.wicketsLost = 0;
        this.overs = new ArrayList<>();
        this.targetRuns = targetRuns;
    }

    public void addOver(Over over) {
        overs.add(over);
        totalRuns += over.getRunsConceded();
        wicketsLost += over.getWickets();
    }

    public double getCurrentRunRate() {
        int totalBalls = 0;
        for (Over o : overs) {
            totalBalls += o.getLegalBalls();
        }
        if (totalBalls == 0) return 0.0;
        return (totalRuns * 6.0) / totalBalls;
    }

    public boolean isTargetChased() {
        return targetRuns != -1 && totalRuns >= targetRuns;
    }

    public String getBattingTeamName() { return battingTeamName; }
    public String getBowlingTeamName() { return bowlingTeamName; }
    public int getTotalRuns() { return totalRuns; }
    public int getWicketsLost() { return wicketsLost; }
    public ArrayList<Over> getOvers() { return overs; }
    public int getTargetRuns() { return targetRuns; }

    @Override
    public String toString() {
        return battingTeamName + " Innings: " + totalRuns + "/" + wicketsLost
                + " (" + overs.size() + " overs) | CRR: " + String.format("%.2f", getCurrentRunRate());
    }
}