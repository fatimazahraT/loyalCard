package com.example.app.Repository;

import com.example.app.Models.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository  extends JpaRepository<Conversion,Long> {
}
