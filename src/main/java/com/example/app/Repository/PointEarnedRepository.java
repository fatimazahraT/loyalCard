package com.example.app.Repository;


import com.example.app.Models.PointEarned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointEarnedRepository  extends JpaRepository<PointEarned,Long> {
}
