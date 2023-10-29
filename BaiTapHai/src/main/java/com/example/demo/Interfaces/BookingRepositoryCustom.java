package com.example.demo.Interfaces;

import org.springframework.data.repository.query.Param;

public interface BookingRepositoryCustom {

    void setABooking(@Param("id") Long id);

}