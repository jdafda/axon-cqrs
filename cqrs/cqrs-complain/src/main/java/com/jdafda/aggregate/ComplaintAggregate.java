package com.jdafda.aggregate;

import com.jdafda.command.FileComplaintCommand;
import com.jdafda.event.ComplaintFileEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by jdafda on 2/12/17.
 */
@Aggregate
public class ComplaintAggregate {

    @AggregateIdentifier
    private String complaintId;

    public ComplaintAggregate() {
    }

    @CommandHandler
    public ComplaintAggregate(FileComplaintCommand cmd) {
        apply(new ComplaintFileEvent(cmd.getId(), cmd.getCompany(), cmd.getDescription()));
    }

    @EventSourcingHandler
    public void on(ComplaintFileEvent event) {
        this.complaintId = event.getId();
    }

}
