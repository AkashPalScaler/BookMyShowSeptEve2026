package com.scaler.bmsseptevening2026.Repositories;

import com.scaler.bmsseptevening2026.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow_Id(Long ShowId);
}
