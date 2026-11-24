public class Batsman extends Player {
    private String battingStyle; 
    private int fours;
    private int sixes;

    public Batsman(String name, String battingStyle) {
        super(name);
        this.battingStyle = battingStyle;
        this.fours = 0;
        this.sixes = 0;
    }

    @Override
    public void addRuns(int runs) {
        super.addRuns(runs);
        if (runs == 4) {
            fours++;
        } else if (runs == 6) {
            sixes++;
        }
    }

    public String getBattingStyle() { return battingStyle; }
    public int getFours() { return fours; }
    public int getSixes() { return sixes; }

    @Override
    public String getRole() {
        return "Batsman (" + battingStyle + ")";
    }

    @Override
    public String toString() {
        return getName() + " [" + getRole() + "] - " + getRunsScored()
                + " (" + getBallsFaced() + ") | 4s: " + fours + ", 6s: " + sixes;
    }
}