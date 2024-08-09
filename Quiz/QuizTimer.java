package Quiz;

import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer {
    private Timer timer;
    private int seconds;
    private boolean timeUp;

    public QuizTimer(int seconds) {
        this.seconds = seconds;
        this.timeUp = false;
        this.timer = new Timer();
    }

    public void start() {
        timer.schedule(new TimerTask() {
            public void run() {
                timeUp = true;
                System.out.println("Time's up!");
                timer.cancel();
            }
        }, seconds * 1000);
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    public void stop() {
        timer.cancel();
    }
}

