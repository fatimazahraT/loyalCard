package com.example.app.Service;

import com.example.app.Models.PointEarned;
import com.example.app.Models.User;
import com.example.app.Repository.PointEarnedRepository;
import com.example.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class PointEarnedServiceImp implements PointEarnedService{
    private final PointEarnedRepository pointEarnedRepository;
    @Autowired
    UserRepository repository;
    @Autowired
    public PointEarnedServiceImp(PointEarnedRepository pointEarnedRepository) {
        this.pointEarnedRepository = pointEarnedRepository;
    }

    @Override
    public PointEarned createPointEarned(PointEarned pointEarned) {
        Double convert = Double.valueOf(String.valueOf(pointEarned.getPurchaseAmount())) * Double.valueOf(0.01);
        pointEarned.setPointsEarned(convert.intValue());
        pointEarned.setEarnedDate(new Date());
        Optional<User> user = repository.findById(pointEarned.getUserId());
        if (user.isPresent()){
            user.get().setTotalPoints(user.get().getTotalPoints()+pointEarned.getPointsEarned());
            return pointEarnedRepository.save(pointEarned);
        }
        return null;

    }

    @Override
    public PointEarned getPointEarnedById(Long earnedId) {
        return pointEarnedRepository.findById(earnedId)
                .orElseThrow(() -> new IllegalArgumentException("PointEarned not found with ID: " + earnedId));
    }

    @Override
    public PointEarned updatePointEarned(Long earnedId, PointEarned updatedPointEarned) {
        PointEarned existingPointEarned = getPointEarnedById(earnedId);
        existingPointEarned.setUserId(updatedPointEarned.getUserId());
        existingPointEarned.setStoreId(updatedPointEarned.getStoreId());
        existingPointEarned.setPurchaseAmount(updatedPointEarned.getPurchaseAmount());
        existingPointEarned.setPointsEarned(updatedPointEarned.getPointsEarned());
        existingPointEarned.setEarnedDate(updatedPointEarned.getEarnedDate());
        return pointEarnedRepository.save(existingPointEarned);
    }

    @Override
    public void deletePointEarned(Long earnedId) {
        pointEarnedRepository.deleteById(earnedId);
    }
}
