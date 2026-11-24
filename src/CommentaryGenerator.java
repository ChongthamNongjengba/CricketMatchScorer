public class CommentaryGenerator {

    public String generateBallCommentary(int overNumber, int ballInOver, Player batsman, Player bowler, Ball ball) {
        StringBuilder sb = new StringBuilder();
        sb.append(overNumber).append(".").append(ballInOver).append(" ");
        sb.append(bowler.getName()).append(" to ").append(batsman.getName()).append(", ");

        if (ball.isWicket()) {
            sb.append("OUT! Big breakthrough for ").append(bowler.getName()).append("!");
        } else if (ball.getExtraType() == ExtraType.WIDE) {
            sb.append("WIDE ball! ").append(ball.getRuns()).append(" extra run(s) added.");
        } else if (ball.getExtraType() == ExtraType.NO_BALL) {
            sb.append("NO BALL! Free hit coming up, ").append(ball.getRuns()).append(" run(s) scored.");
        } else if (ball.getRuns() == 6) {
            sb.append("SIX! Massive hit straight into the stands by ").append(batsman.getName()).append("!");
        } else if (ball.getRuns() == 4) {
            sb.append("FOUR! Cracked through the gap for a boundary!");
        } else if (ball.getRuns() == 0) {
            sb.append("no run, solid defense.");
        } else {
            sb.append(ball.getRuns()).append(" run(s) taken.");
        }

        return sb.toString();
    }

    public String checkMilestone(Player batsman) {
        int runs = batsman.getRunsScored();
        if (runs >= 100 && runs < 106) {
            return "MILESTONE: " + batsman.getName() + " reaches a brilliant CENTURY!";
        } else if (runs >= 50 && runs < 56) {
            return "MILESTONE: " + batsman.getName() + " brings up a well-made HALF-CENTURY!";
        }
        return "";
    }
}
