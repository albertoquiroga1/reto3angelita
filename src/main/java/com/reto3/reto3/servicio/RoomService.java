package com.reto3.reto3.servicio;

import com.reto3.reto3.entidad.Room;
import com.reto3.reto3.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll(){
        return roomRepository.getAll();
    }

    public Optional<Room> getRoom(int id) {
        return roomRepository.getRoom(id);
    }
    public Room save (Room room) {
        if(room.getId()==null) {
            return roomRepository.save(room);
        } else {
            Optional<Room> roomFound = getRoom(room.getId());
            if(roomFound.isEmpty()) {
                return roomRepository.save(room);
            }else{
                return room;
            }
        }
    }
}
