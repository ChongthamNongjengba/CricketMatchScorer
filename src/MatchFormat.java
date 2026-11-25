public enum MatchFormat {
    T10(10, 2),
    T20(20, 4),
    ODI(50, 10);

    private final int maxOvers;
    private final int maxOversPerBowler;

    MatchFormat(int maxOvers, int maxOversPerBowler) {
        this.maxOvers = maxOvers;
        this.maxOversPerBowler = maxOversPerBowler;
    }

    public int getMaxOvers() {
        return maxOvers;
    }

    public int getMaxOversPerBowler() {
        return maxOversPerBowler;
    }
}
