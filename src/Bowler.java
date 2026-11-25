public class Bowler extends Player {
    private String bowlingStyle; // e.g., "Fast", "Spin"

    public Bowler(String name, String bowlingStyle) {
        super(name);
        this.bowlingStyle = bowlingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    @Override
    public String getRole() {
        return "Bowler (" + bowlingStyle + ")";
    }

    @Override
    public String toString() {
        return getName() + " [" + getRole() + "] - Wickets: " + getWicketsTaken()
                + ", Economy: " + String.format("%.2f", getEconomyRate());
    }
}
