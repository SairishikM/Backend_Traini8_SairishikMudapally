// package com.traini8.controller;

// import com.traini8.model.TrainingCenter;
// import com.traini8.service.TrainingCenterService;
// import jakarta.validation.Valid;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/training-centers")
// public class TrainingCenterController {

//     private final TrainingCenterService service;

//     public TrainingCenterController(TrainingCenterService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter center) {
//         return ResponseEntity.ok(service.saveTrainingCenter(center));
//     }

//     @GetMapping
//     public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
//         return ResponseEntity.ok(service.getAllTrainingCenters());
//     }
// }
package com.traini8.controller;

import com.traini8.model.TrainingCenter;
import com.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter center) {
        return ResponseEntity.ok(service.saveTrainingCenter(center));
    }

    // Updated GET API to support filtering by state
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(@RequestParam(required = false) String state) {
        return ResponseEntity.ok(service.getAllTrainingCenters(state));
    }
}
