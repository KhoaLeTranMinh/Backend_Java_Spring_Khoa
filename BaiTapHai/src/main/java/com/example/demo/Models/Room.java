package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@Table
public class Room {
    public Room(String roomName, boolean available) {
        this.roomName = roomName;
        this.available = available;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomName;
    private boolean available;

}
