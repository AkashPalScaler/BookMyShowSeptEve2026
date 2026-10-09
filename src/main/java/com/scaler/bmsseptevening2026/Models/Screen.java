package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
    @OneToMany(mappedBy = "screen")
    private List<Show> shows;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;
    @ManyToOne
    private Theatre theatre;
}
// mapping table : screen id | Feature
//                  1  | TWO_D
//                  1  | DOLBY
