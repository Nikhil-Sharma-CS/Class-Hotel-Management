package org.example.ClassHotelManagement.Model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(unique = true)
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    private Type roomType;

    private Double roomPrice;

    @Column(name = "status")
    private Boolean roomStatus;
}
