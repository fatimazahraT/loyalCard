package com.example.app.Service;

import com.example.app.Models.PointEarned;

public interface PointEarnedService {
    PointEarned createPointEarned(PointEarned pointEarned);
    PointEarned getPointEarnedById(Long earnedId);
    PointEarned updatePointEarned(Long earnedId, PointEarned updatedPointEarned);
    void deletePointEarned(Long earnedId);
}
