package com.example.demo.ImplementationRepo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.Interfaces.BookingRepository;
import com.example.demo.Interfaces.BookingRepositoryCustom;
import com.example.demo.Interfaces.RoomRepository;
import com.example.demo.Models.Booking;
import com.example.demo.Models.Room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class BookingRepositoryImpl implements BookingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Lazy
    private BookingRepository bookingRepositoryObject;

    @Autowired
    private RoomRepository roomRepositoryObject;

    // @Override
    // @Modifying
    // @Transactional
    @Query("update Room r set r.available = false where r.id = :id")
    @Modifying
    @Transactional
    public void setABooking(@Param("id") Long roomId) {
        // OptmisticLock
        entityManager.find(Room.class, roomId, LockModeType.OPTIMISTIC);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(2);
        Booking newBooking = new Booking(roomId, startDate, endDate);
        bookingRepositoryObject.save(newBooking);
        Optional<Room> bookedRoom = roomRepositoryObject.findById(roomId);
        bookedRoom.ifPresent(room -> room.setAvailable(false));
        String roomName = bookedRoom.map(Room::getRoomName).orElse(null);
        System.out.println("Room " + roomName + " is booked!");
    };
}
