import java.util.HashMap;

public class BowlerQuotaValidator {
    private HashMap<Integer, Integer> bowlerOversMap;
    private MatchFormat format;

    public BowlerQuotaValidator(MatchFormat format) {
        this.bowlerOversMap = new HashMap<>();
        this.format = format;
    }

    public void recordOverBowled(Bowler bowler) throws InvalidOverException {
        int currentOvers = bowlerOversMap.getOrDefault(bowler.getPlayerId(), 0);
        if (currentOvers >= format.getMaxOversPerBowler()) {
            throw new InvalidOverException(bowler.getName() + " has already bowled the max quota of "
                    + format.getMaxOversPerBowler() + " overs in " + format + ".");
        }
        bowlerOversMap.put(bowler.getPlayerId(), currentOvers + 1);
    }

    public int getOversBowledBy(Bowler bowler) {
        return bowlerOversMap.getOrDefault(bowler.getPlayerId(), 0);
    }
}