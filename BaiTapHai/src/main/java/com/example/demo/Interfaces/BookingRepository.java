package com.example.demo.Interfaces;

import com.example.demo.Models.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

    Booking findById(long id);

    <S extends Booking> S save(S entity);

}