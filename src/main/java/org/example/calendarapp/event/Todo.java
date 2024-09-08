package org.example.calendarapp.event;

import java.time.ZonedDateTime;

public class Todo extends AbstractEvent{
    private String desciption;

    public Todo(int id, String title,
                ZonedDateTime startAt, ZonedDateTime endAt,
                String desciption) {
        super(id, title, startAt, endAt);

        this.desciption = desciption;
    }

    @Override
    public void print() {
        System.out.println("[할 일] " + getTitle() + " : " + this.desciption);
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.TO_DO;
    }

    @Override
    protected void update(AbstractAuditableEvent event) {

    }
}
