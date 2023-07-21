package org.example.ClassHotelManagement.Service;

import org.example.ClassHotelManagement.Model.Room;
import org.example.ClassHotelManagement.Repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    IRoomRepo roomRepo;

    public List<Room> getRooms() {
        return roomRepo.findAll();
    }


    public List<Room> roomByPrice() {
        return roomRepo.findByRoomStatusOrderByRoomPriceDesc(false);
    }

    public List<Room> roomAvailable() {
        return roomRepo.findByroomStatus(false);
    }

    public String addRooms(List<Room> rooms) {
        roomRepo.saveAll(rooms);
        return "Rooms Saved";
    }

    public String deleteRoom(Integer id) {
        if(roomRepo.existsById(id))
        {
            roomRepo.deleteById(id);
            return "Room deleted";
        }
        return "Room not found";
    }


    public String updatePrice(Integer id, Double price) {
        Room room = roomRepo.findById(id).orElse(null);

        if(room != null)
        {
            room.setRoomPrice(price);
            roomRepo.save(room);
            return "Room Price Updated";
        }
        return "Room not found";
    }
}
