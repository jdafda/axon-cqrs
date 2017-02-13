package com.jdafda;

import com.jdafda.domain.Complaint;
import com.jdafda.event.ComplaintFileEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by jdafda on 2/12/17.
 */
@Component
public class ComplaintQueryUpdate {

    private final ComplaintRepository complaintRepository;

    public ComplaintQueryUpdate(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @EventHandler
    public void saveComplaint(ComplaintFileEvent complaintFileEvent) {
        complaintRepository.save(new Complaint(complaintFileEvent.getId(),
                complaintFileEvent.getCompany(),
                complaintFileEvent.getDescription()));
    }

}
