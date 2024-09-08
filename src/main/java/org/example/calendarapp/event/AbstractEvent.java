package org.example.calendarapp.event;

import org.example.calendarapp.exception.InvalidEventException;

import java.time.Duration;
import java.time.ZonedDateTime;

public abstract class AbstractEvent implements Event{
    private final int id;
    private String title;

    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private Duration duration;

    private final ZonedDateTime createAt;
    private ZonedDateTime modifiedAt;

    private boolean deletedYn;

    protected AbstractEvent(int id, String title, ZonedDateTime startAt, ZonedDateTime endAt) {
        if(startAt.isAfter(endAt)){
            throw new InvalidEventException(
                    String.format("시작일은 종료일보다 이전이어야 합니다. 시작일 = %s, 종료일 = %s", startAt, endAt)
            );
        }

        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createAt = ZonedDateTime.now();
        this.modifiedAt = ZonedDateTime.now();
        this.deletedYn = false;
        this.duration = Duration.between(startAt, endAt);
    }
    public void valideteAndUpdate(AbstractAuditableEvent update){
        if(deletedYn){
            throw new RuntimeException("이미 삭제된 이벤트는 수정할 수 없음.");
        }
        defaultUpdate(update);
        update(update);
    }

    private void defaultUpdate(AbstractAuditableEvent update) {
        this.title = update.getTitle();
        this.startAt = update.getStartAt();
        this.endAt = update.getEndAt();
        this.duration = Duration.between(this.startAt, this.endAt);
        this.modifiedAt = ZonedDateTime.now();
    }

    protected abstract void update(AbstractAuditableEvent event);

    public void delete(boolean deletedYn){
        this.deletedYn = deletedYn;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }

    public Duration getDuration() {
        return duration;
    }

    public ZonedDateTime getCreateAt() {
        return createAt;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public boolean isDeletedYn() {
        return deletedYn;
    }
}
