package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(long l) {
        TimeEntry t = timeEntryRepository.find(l);
        HttpStatus h = t==null ? HttpStatus.NOT_FOUND: HttpStatus.OK;
        return new ResponseEntity<TimeEntry>(t,h);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list(), HttpStatus.OK) ;

    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity update(long l, TimeEntry expected) {
        TimeEntry te = timeEntryRepository.update(l,expected);
        HttpStatus hs = te==null ? HttpStatus.NOT_FOUND: HttpStatus.OK;

        return new ResponseEntity(te, hs);

    }
    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity delete(long l) {
        Long objectLong = (Long)l;
        timeEntryRepository.delete(l);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
