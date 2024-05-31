package util;

public class Statistics {
    private int wins;
    private int losses;

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    public String getStatistics() {
        return String.format("Zwycięstwa: %d, Porażki: %d", wins, losses);
    }
}
