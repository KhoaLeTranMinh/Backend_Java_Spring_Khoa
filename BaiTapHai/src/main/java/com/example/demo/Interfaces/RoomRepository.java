package com.example.demo.Interfaces;

import java.util.List;
import com.example.demo.Models.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findById(long id);

    List<Room> findByRoomName(String roomName);

    <S extends Room> S save(S entity);

}