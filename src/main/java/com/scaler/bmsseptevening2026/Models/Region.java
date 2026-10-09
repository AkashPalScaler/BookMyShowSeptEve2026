package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel {
    private String name;
    // Region 1:M Theatre
    @OneToMany(mappedBy="region")
    private List<Theatre> theatres;
}
// region - id | name | [theatre_id1, id2, id3]
//          1    mumbai  [3, 4, 5]
// Normalise it:
//          1    mumbai  [3]
//          1    mumbai  [4]
//          1    mumbai  [5]
