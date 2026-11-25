import java.util.ArrayList;

public class Over {
    private int overNumber;
    private Bowler bowler;
    private ArrayList<Ball> deliveries;
    private int legalBalls;
    private int runsConceded;
    private int wickets;

    public Over(int overNumber, Bowler bowler) {
        this.overNumber = overNumber;
        this.bowler = bowler;
        this.deliveries = new ArrayList<>();
        this.legalBalls = 0;
        this.runsConceded = 0;
        this.wickets = 0;
    }

    public void addBall(Ball ball) throws InvalidOverException {
        if (isCompleted()) {
            throw new InvalidOverException("Over " + overNumber + " already has 6 legal deliveries.");
        }
        deliveries.add(ball);
        runsConceded += ball.getRuns();
        if (ball.isWicket()) {
            wickets++;
        }
        if (ball.isLegalDelivery()) {
            legalBalls++;
            bowler.addDeliveryBowled(ball.getRuns(), ball.isWicket());
        }
    }

    public boolean isCompleted() {
        return legalBalls >= 6;
    }

    public boolean isMaiden() {
        return isCompleted() && runsConceded == 0;
    }

    public int getOverNumber() { return overNumber; }
    public Bowler getBowler() { return bowler; }
    public ArrayList<Ball> getDeliveries() { return deliveries; }
    public int getLegalBalls() { return legalBalls; }
    public int getRunsConceded() { return runsConceded; }
    public int getWickets() { return wickets; }

    @Override
    public String toString() {
        return "Over " + overNumber + " (" + bowler.getName() + "): "
                + deliveries.toString() + " | Runs: " + runsConceded + ", Wickets: " + wickets;
    }
}
