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
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

    Booking findById(long id);

    <S extends Booking> S save(S entity);

}