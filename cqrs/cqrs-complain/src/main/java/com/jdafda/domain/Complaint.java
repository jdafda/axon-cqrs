package com.jdafda.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jdafda on 2/12/17.
 */
@Entity
public class Complaint {

    @Id
    private String id;
    private String company;
    private String description;

    protected Complaint() {
    }

    public Complaint(String id, String company, String description) {
        this.id = id;
        this.company = company;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }
}
