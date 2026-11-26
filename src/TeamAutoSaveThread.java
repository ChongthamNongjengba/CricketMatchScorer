public class TeamAutoSaveThread extends Thread {
    private Team team;
    private boolean running;
    private String lastSavedSnapshot;
    private int saveCount;

    public TeamAutoSaveThread(Team team) {
        this.team = team;
        this.running = true;
        this.lastSavedSnapshot = "";
        this.saveCount = 0;
        setDaemon(true);
        setName("AutoSave-" + team.getTeamName());
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                lastSavedSnapshot = team.toString();
                saveCount++;
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void stopAutoSave() {
        this.running = false;
        this.interrupt();
    }

    public String getLastSavedSnapshot() { return lastSavedSnapshot; }
    public int getSaveCount() { return saveCount; }
}