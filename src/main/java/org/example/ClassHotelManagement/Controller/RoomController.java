package org.example.ClassHotelManagement.Controller;


import jakarta.persistence.GeneratedValue;
import org.example.ClassHotelManagement.Model.Room;
import org.example.ClassHotelManagement.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("rooms")
    List<Room> getRooms()
    {
        return roomService.getRooms();
    }

    @GetMapping("roomAvailable")
    List<Room> roomByStatus()
    {
        return roomService.roomAvailable();
    }

    @GetMapping("roomByPrice")
    List<Room> roomByPrice()
    {
        return roomService.roomByPrice();
    }

    @PostMapping("addRooms")
    String addRooms(@RequestBody List<Room> rooms)
    {
        return roomService.addRooms(rooms);
    }

    @DeleteMapping("deleteRoom/{id}")
    String deleteRoom(@PathVariable Integer id)
    {
        return roomService.deleteRoom(id);
    }

    @PutMapping("updatePrice")
    String updatePrice(@RequestParam Integer Id, @RequestParam Double price)
    {
        return roomService.updatePrice(Id, price);
    }
}
