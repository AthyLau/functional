package com.demik.functional.test;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author AthyLau
 * @dare: 2019/10/8 3:01 PM
 * @since JDK 1.8
 */
public class Test {
    public static void main(String args[]) {
        Details details = new Details(Arrays.asList(new Details.Event(1, false), new Details.Event(2, false)));
        List<Details.Event> events = details.getEvents();
        events.stream().map(x -> x.setReplay(true)).collect(Collectors.toList());
        details.getEvents().forEach(x->{
            System.out.println(x.getEventId() + "  " + x.getReplay());
        });
    }
}
@Getter
@Setter
@Accessors(chain = true)
class Details {
    private List<Event> events;

    @Data
    @Getter
    @Setter
    @Accessors(chain = true)
    static class Event {
        private Integer eventId;
        private Boolean replay = false;

        public Event(Integer eventId, boolean replay) {
            this.eventId = eventId;
            this.replay = replay;
        }
    }

    public Details(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Details{" +
                "events=" + events +
                '}';
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}