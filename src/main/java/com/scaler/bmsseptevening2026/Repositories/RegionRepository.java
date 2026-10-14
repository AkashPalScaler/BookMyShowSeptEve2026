package com.scaler.bmsseptevening2026.Repositories;

import com.scaler.bmsseptevening2026.Models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
