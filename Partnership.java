public class Partnership {
    private Player batter1;
    private Player batter2;
    private int runs;
    private int balls;

    public Partnership(Player batter1, Player batter2) {
        this.batter1 = batter1;
        this.batter2 = batter2;
        this.runs = 0;
        this.balls = 0;
    }

    public void addBall(int runsScored, boolean isLegalDelivery) {
        this.runs += runsScored;
        if (isLegalDelivery) {
            this.balls++;
        }
    }

    public Player getBatter1() { return batter1; }
    public Player getBatter2() { return batter2; }
    public int getRuns() { return runs; }
    public int getBalls() { return balls; }

    @Override
    public String toString() {
        return "Partnership (" + batter1.getName() + " & " + batter2.getName() + "): "
                + runs + " runs (" + balls + " balls)";
    }
}