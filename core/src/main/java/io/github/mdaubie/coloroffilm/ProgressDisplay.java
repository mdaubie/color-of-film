package io.github.mdaubie.coloroffilm;

//TODO the delay slightly increases linearly
// add a real time measurement of this increase to more accurately calculate the ETA
public class ProgressDisplay {
    private final int total;
    private final long startTime;

    public ProgressDisplay(int total) {
        this.total = total;
        this.startTime = System.currentTimeMillis();
    }

    public void print(int current, long delay) {
        int percentage = (current) * 100 / total;
        long eta = (long) ((System.currentTimeMillis() - startTime) * ((float) total / current - 1)); //in ms
        String progression = String.format("\rProgression: %d%%, ETA:%s (Read chunk %d/%d in %dms)",
                percentage, formatMSDuration(eta), current, total, delay);
        System.out.print(progression);
    }

    public void printCompletion() {
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.printf("Process completed in %s%n", formatMSDuration(totalTime));
    }

    private static String formatMSDuration(long msDuration) {
        int seconds = (int) (msDuration / 1000);
        return String.format("%d:%02d:%02d",
                seconds / 3600, (seconds % 3600) / 60, seconds % 60);
    }
}
