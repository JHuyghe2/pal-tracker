package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    List<TimeEntry> listOfTimeEntry = new ArrayList<TimeEntry>();
    private long id = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        id++;
        //long userId, LocalDate date, int hours
        TimeEntry newTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        listOfTimeEntry.add(newTimeEntry);
        return newTimeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        for(TimeEntry l:listOfTimeEntry)
        {
            if(l.getId()==id)
            {
                return l;
            }
        }
        return null;
    }

    @Override
    public List<TimeEntry> list() {

        return listOfTimeEntry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry te2 = (TimeEntry)find(id);
        te2.setProjectId(timeEntry.getProjectId());
        te2.setDate(timeEntry.getDate());
        te2.setUserId(timeEntry.getUserId());
        te2.setHours(timeEntry.getHours());
        return te2;
    }

    @Override
    public void delete(long id) {

        listOfTimeEntry.remove(find(id));
    }
}
