package algomaster.problems.stackoverflow.event;

import algomaster.problems.stackoverflow.domainmodel.Post;
import algomaster.problems.stackoverflow.domainmodel.User;
import algomaster.problems.stackoverflow.enums.EventType;

public class Event {
    private final EventType eventType;
    private final User actor;
    private final Post target;

    public Event(EventType eventType, User actor, Post target) {
        this.eventType = eventType;
        this.actor = actor;
        this.target = target;
    }

    public EventType getEventType() {
        return eventType;
    }

    public User getActor() {
        return actor;
    }

    public Post getTarget() {
        return target;
    }
}
