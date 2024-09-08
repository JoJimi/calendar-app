package org.example.calendarapp.event;

import java.time.ZonedDateTime;
import java.util.Set;

public class UpdateMeeting extends AbstractAuditableEvent{
    private Set<String> participants;
    private String meetingRoom;
    private String agenda;

    public UpdateMeeting(String title, ZonedDateTime startAt, ZonedDateTime endAt, Set<String> participants, String meetingRoom, String agenda) {
        super(title, startAt, endAt);
        this.participants = participants;
        this.meetingRoom = meetingRoom;
        this.agenda = agenda;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public String getAgenda() {
        return agenda;
    }
}
