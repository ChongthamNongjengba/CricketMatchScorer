public class AllRounder extends Player {
    private String battingStyle;
    private String bowlingStyle;

    public AllRounder(String name) {
        super(name);
        this.battingStyle = "Right-Handed";
        this.bowlingStyle = "Right-Arm Medium";
    }

    public AllRounder(String name, String battingStyle, String bowlingStyle) {
        super(name);
        this.battingStyle = battingStyle;
        this.bowlingStyle = bowlingStyle;
    }

    @Override
    public String getRole() {
        return "All-Rounder";
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public int getAllRounderImpactScore() {
        return getRunsScored() + (getWicketsTaken() * 25);
    }

    @Override
    public String toString() {
        return getName() + " [" + getRole() + " | " + battingStyle + ", " + bowlingStyle + "] - "
                + "Runs: " + getRunsScored() + ", Wickets: " + getWicketsTaken();
    }
}
