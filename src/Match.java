public class Match {
    private static int matchCounter = 101;

    private int matchId;
    private String teamAName;
    private String teamBName;
    private MatchFormat format;
    private Innings firstInnings;
    private Innings secondInnings;
    private String matchResult;

    public Match(String teamAName, String teamBName, MatchFormat format) {
        this.matchId = matchCounter++;
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.format = format;
        this.matchResult = "In Progress";
    }

    public void startFirstInnings(String battingTeam, String bowlingTeam) {
        this.firstInnings = new Innings(battingTeam, bowlingTeam, -1);
    }

    public void startSecondInnings(String battingTeam, String bowlingTeam) {
        int target = (firstInnings != null) ? firstInnings.getTotalRuns() + 1 : 1;
        this.secondInnings = new Innings(battingTeam, bowlingTeam, target);
    }

    public void calculateResult() {
        if (firstInnings == null || secondInnings == null) {
            matchResult = "Match Incomplete";
            return;
        }
        int score1 = firstInnings.getTotalRuns();
        int score2 = secondInnings.getTotalRuns();

        if (score2 > score1) {
            int wicketsRemaining = 10 - secondInnings.getWicketsLost();
            matchResult = secondInnings.getBattingTeamName() + " won by " + wicketsRemaining + " wickets";
        } else if (score1 > score2) {
            int runMargin = score1 - score2;
            matchResult = firstInnings.getBattingTeamName() + " won by " + runMargin + " runs";
        } else {
            matchResult = "Match Tied!";
        }
    }

    public int getMatchId() { return matchId; }
    public String getTeamAName() { return teamAName; }
    public String getTeamBName() { return teamBName; }
    public MatchFormat getFormat() { return format; }
    public Innings getFirstInnings() { return firstInnings; }
    public Innings getSecondInnings() { return secondInnings; }
    public String getMatchResult() { return matchResult; }
}