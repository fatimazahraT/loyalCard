package com.example.app.Controler;

import com.example.app.Models.PointEarned;
import com.example.app.Service.PointEarnedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/point-earned")
public class PointEarnedController {

    private final PointEarnedService pointEarnedService;

    @Autowired
    public PointEarnedController(PointEarnedService pointEarnedService) {
        this.pointEarnedService = pointEarnedService;
    }

    @GetMapping("/{earnedId}")
    public ResponseEntity<PointEarned> getPointEarnedById(@PathVariable Long earnedId) {
        PointEarned pointEarned = pointEarnedService.getPointEarnedById(earnedId);
        return ResponseEntity.ok(pointEarned);
    }

    @PostMapping("/create")
    public ResponseEntity<PointEarned> createPointEarned(@RequestBody PointEarned pointEarned) {

        PointEarned createdPointEarned = pointEarnedService.createPointEarned(pointEarned);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPointEarned);
    }

    @PutMapping("/{earnedId}")
    public ResponseEntity<PointEarned> updatePointEarned(@PathVariable Long earnedId, @RequestBody PointEarned updatedPointEarned) {
        PointEarned pointEarned = pointEarnedService.updatePointEarned(earnedId, updatedPointEarned);
        return ResponseEntity.ok(pointEarned);
    }

    @DeleteMapping("/{earnedId}")
    public ResponseEntity<Void> deletePointEarned(@PathVariable Long earnedId) {
        pointEarnedService.deletePointEarned(earnedId);
        return ResponseEntity.noContent().build();
    }
}

