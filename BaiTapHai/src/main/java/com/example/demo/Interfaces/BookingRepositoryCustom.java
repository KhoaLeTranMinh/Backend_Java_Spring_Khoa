package com.example.demo.Interfaces;

import java.util.List;

import com.example.demo.Models.Booking;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepositoryCustom {

    @Modifying
    @Transactional
    @Query("update Room r set r.available = false where r.id = :id")
    void setABooking(@Param("id") Long id);

    // @Transactional
    // @Query("update Room r set r.available = false where r.id = :id")
    // void setABooking(@Param("id") Long id);
}