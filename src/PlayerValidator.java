public class PlayerValidator {

    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        String trimmed = name.trim();
        if (trimmed.length() < 2) {
            return false;
        }
        for (int i = 0; i < trimmed.length(); i++) {
            char ch = trimmed.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }

    public static String formatName(String name) {
        String trimmed = name.trim();
        return trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1);
    }

    public static int parseRuns(String input) {
        int runs = Integer.parseInt(input.trim());
        if (runs < 0 || runs > 6) {
            throw new IllegalArgumentException("Runs per ball must be between 0 and 6.");
        }
        return runs;
    }

    public static double parseRequiredRunRate(String input) {
        double rate = Double.parseDouble(input.trim());
        if (rate < 0.0) {
            throw new IllegalArgumentException("Run rate cannot be negative.");
        }
        return rate;
    }
}
