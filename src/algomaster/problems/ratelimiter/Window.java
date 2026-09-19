package algomaster.problems.ratelimiter;

import java.time.Duration;
import java.time.Instant;

public class Window {
    public static final Instant baseInstant = Instant.now();
    private long start;
    private long end;
    private long count;
    private long windowSizeSeconds;

    public Window(long windowSizeSeconds) {
        this.windowSizeSeconds = windowSizeSeconds;
        updateWindow();
    }

    public void updateWindow(){
        Instant currentInsant = Instant.now();
        long second = Duration.between(baseInstant, currentInsant).getSeconds();
        long intervalNumber = second/windowSizeSeconds;
        if(this.start == intervalNumber*windowSizeSeconds && this.end == this.start + windowSizeSeconds) return;
        this.start = intervalNumber*windowSizeSeconds;
        this.end = this.start + windowSizeSeconds;
        this.count = 1;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public long getCount() {
        return count;
    }

    public void addRequest(){
        count++;
    }
    
}
