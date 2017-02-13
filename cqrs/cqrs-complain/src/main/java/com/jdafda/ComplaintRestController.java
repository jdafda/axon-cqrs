package com.jdafda;

import com.jdafda.command.FileComplaintCommand;
import com.jdafda.domain.Complaint;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Created by jdafda on 2/12/17.
 */

@RestController
@RequestMapping(value = "/complaints")
public class ComplaintRestController {

    private final ComplaintRepository complaintRepository;
    private final CommandGateway commandGateway;

    public ComplaintRestController(ComplaintRepository complaintRepository, CommandGateway commandGateway) {
        this.complaintRepository = complaintRepository;
        this.commandGateway = commandGateway;
    }

    @GetMapping("/{id}")
    public Complaint find(@PathVariable String id) {
        return complaintRepository.findOne(id);
    }

    @GetMapping
    public List<Complaint> findAll() {
        return complaintRepository.findAll();
    }

    @PostMapping
    public CompletableFuture<String> fileComplaint(@RequestBody Complaint complaint) {
        String id = UUID.randomUUID().toString();
        return commandGateway.send(new FileComplaintCommand(id, complaint.getCompany(), complaint.getDescription()));
    }

}
