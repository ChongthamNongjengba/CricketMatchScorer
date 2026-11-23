public class Ball {
    private static int ballCounter = 1;

    private int ballId;
    private int runs;
    private boolean isWicket;
    private ExtraType extraType;

    public Ball(int runs, boolean isWicket, ExtraType extraType) {
        this.ballId = ballCounter++;
        this.runs = runs;
        this.isWicket = isWicket;
        this.extraType = extraType;
    }

    public boolean isLegalDelivery() {
        return extraType != ExtraType.WIDE && extraType != ExtraType.NO_BALL;
    }

    public int getBallId() { return ballId; }
    public int getRuns() { return runs; }
    public boolean isWicket() { return isWicket; }
    public ExtraType getExtraType() { return extraType; }

    public static int getTotalBallsRecorded() {
        return ballCounter - 1;
    }

    @Override
    public String toString() {
        if (isWicket) return "W";
        if (extraType != ExtraType.NONE) return runs + "(" + extraType + ")";
        return String.valueOf(runs);
    }
}
