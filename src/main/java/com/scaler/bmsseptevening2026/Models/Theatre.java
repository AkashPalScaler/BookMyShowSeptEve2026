package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    @ManyToOne
    private Region region;
    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;

    // Method - Should only work with properties inside it
}
// Theatre - id | created_at | updated_at | name | region_id