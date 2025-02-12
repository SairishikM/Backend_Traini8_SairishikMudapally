// package com.traini8.service;

// import com.traini8.model.TrainingCenter;
// import com.traini8.repository.TrainingCenterRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TrainingCenterService {

//     private final TrainingCenterRepository repository;

//     public TrainingCenterService(TrainingCenterRepository repository) {
//         this.repository = repository;
//     }

//     public TrainingCenter saveTrainingCenter(TrainingCenter center) {
//         return repository.save(center);
//     }

//     public List<TrainingCenter> getAllTrainingCenters() {
//         return repository.findAll();
//     }
// }
package com.traini8.service;

import com.traini8.model.TrainingCenter;
import com.traini8.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public TrainingCenter saveTrainingCenter(TrainingCenter center) {
        return repository.save(center);
    }

    // Modified method to allow filtering by state
    public List<TrainingCenter> getAllTrainingCenters(String state) {
        List<TrainingCenter> centers = repository.findAll();

        if (state != null && !state.isEmpty()) {
            return centers.stream()
                    .filter(center -> center.getAddress().getState().equalsIgnoreCase(state))
                    .collect(Collectors.toList());
        }
        return centers;
    }
}
