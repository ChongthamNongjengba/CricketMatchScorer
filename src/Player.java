public abstract class Player implements Scorable, Comparable<Player> {
    private static int idCounter = 1;

    private int playerId;
    private String name;
    private int runsScored;
    private int ballsFaced;
    private int wicketsTaken;
    private int runsConceded;
    private int ballsBowled;
    private boolean isOut;

    public Player(String name) {
        this.playerId = idCounter++;
        this.name = name;
        this.isOut = false;
    }

    public abstract String getRole();

    @Override
    public void addRuns(int runs) {
        if (runs >= 0) {
            this.runsScored += runs;
            this.ballsFaced++;
        }
    }

    public void addDeliveryBowled(int runsConceded, boolean isWicket) {
        this.ballsBowled++;
        this.runsConceded += runsConceded;
        if (isWicket) {
            this.wicketsTaken++;
        }
    }

    @Override
    public double getStrikeRate() {
        if (ballsFaced == 0) {
            return 0.0;
        }
        return (runsScored * 100.0) / ballsFaced;
    }

    public double getEconomyRate() {
        double overs = ballsBowled / 6.0;
        if (overs == 0) {
            return 0.0;
        }
        return runsConceded / overs;
    }

    // Sorts players by highest runs first
    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.runsScored, this.runsScored);
    }

    public int getPlayerId() { return playerId; }
    public String getName() { return name; }
    @Override
    public int getRunsScored() { return runsScored; }
    public int getBallsFaced() { return ballsFaced; }
    public int getWicketsTaken() { return wicketsTaken; }
    public int getRunsConceded() { return runsConceded; }
    public int getBallsBowled() { return ballsBowled; }
    public boolean isOut() { return isOut; }
    public void setOut(boolean out) { this.isOut = out; }

    @Override
    public String toString() {
        return name + " (" + getRole() + ") - " + runsScored + " (" + ballsFaced + ")";
    }
}