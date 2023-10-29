package com.example.demo.ImplementationRepo;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.Interfaces.BookingRepository;
import com.example.demo.Interfaces.BookingRepositoryCustom;
import com.example.demo.Interfaces.RoomRepository;
import com.example.demo.Models.Booking;
import com.example.demo.Models.Room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class BookingRepositoryImpl implements BookingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Lazy
    private BookingRepository bookingRepositoryObject;

    @Autowired
    private RoomRepository roomRepositoryObject;

    public void setABooking(@Param("id") Long roomId) {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(2);
        Booking newBooking = new Booking(roomId, startDate, endDate);
        bookingRepositoryObject.save(newBooking);
        Optional<Room> bookedRoom = roomRepositoryObject.findById(roomId);
        // bookedRoom.ifPresent(room -> room.setAvailable(false));
        String roomName = bookedRoom.map(Room::getRoomName).orElse(null);
        System.out.println("Room " + roomName + "is booked!");
    };
}
