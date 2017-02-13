package com.jdafda;

import com.jdafda.event.ComplaintFileEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdafda on 2/12/17.
 */

@ProcessingGroup("view")
@RestController
public class ComplaintQuery {

    private static List<ComplaintFileEvent> complaintFileEvents = new ArrayList<>();


    @GetMapping("/events")
    public List<ComplaintFileEvent> getComplaintFileEvents() {
        return complaintFileEvents;
    }

    @EventHandler
    public void on(ComplaintFileEvent event) {
        System.out.println(event);
        complaintFileEvents.add(event);
    }


}
