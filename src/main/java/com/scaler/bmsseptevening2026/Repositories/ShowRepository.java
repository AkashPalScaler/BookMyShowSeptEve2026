package com.scaler.bmsseptevening2026.Repositories;

import com.scaler.bmsseptevening2026.Models.Show;
import com.scaler.bmsseptevening2026.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
