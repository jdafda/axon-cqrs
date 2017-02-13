package com.jdafda;

import com.jdafda.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jdafda on 2/12/17.
 */
@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, String> {
}
