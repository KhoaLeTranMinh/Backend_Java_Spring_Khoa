package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long room_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate endDate;

    @Version
    private Integer version;

    public Booking(Long room_id, LocalDate startDate, LocalDate endDate) {
        this.room_id = room_id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
