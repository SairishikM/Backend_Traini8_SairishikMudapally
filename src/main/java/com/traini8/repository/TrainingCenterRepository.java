package com.traini8.repository;

import com.traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    // Filtering by state
    List<TrainingCenter> findByAddress_State(String state);
}
