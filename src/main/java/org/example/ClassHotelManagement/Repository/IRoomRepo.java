package org.example.ClassHotelManagement.Repository;

import jakarta.transaction.Transactional;
import org.example.ClassHotelManagement.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoomRepo extends JpaRepository<Room, Integer> {
    List<Room> findByroomStatus(boolean status);


    List<Room> findByRoomStatusOrderByRoomPriceDesc(Boolean status);
}
