package algomaster.problems.ratelimiter;

import java.util.HashMap;

public class FixedWindowRateLimitingStrategy implements RateLimitingStrategy{
    public static final long MAX_REQUESTS = 3;
    public static final long WINDOW_SIZE = 5;
    private HashMap<String, Window> userWindows = new HashMap<>();

    @Override
    public boolean isRequestAllowed(Request request) {
        String userId = request.getUserId();
        Window userWindow = userWindows.get(userId);

        if(userWindow == null){
            // user's first request, create the window
            userWindow = new Window(WINDOW_SIZE);
            userWindows.put(userId, userWindow);
        }else userWindow.updateWindow();

        if(userWindow.getCount() == MAX_REQUESTS) return false;
        userWindow.addRequest();
        return true;
    }
    
}
