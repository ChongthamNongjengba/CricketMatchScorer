public class MatchTimerThread extends Thread {
    private int elapsedSeconds;
    private boolean running;

    public MatchTimerThread() {
        this.elapsedSeconds = 0;
        this.running = true;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                elapsedSeconds++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stopTimer() {
        this.running = false;
    }

    public String getFormattedDuration() {
        int mins = elapsedSeconds / 60;
        int secs = elapsedSeconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }
}