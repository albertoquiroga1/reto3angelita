package com.reto3.reto3.servicio;

import com.reto3.reto3.entidad.Reservation;
import com.reto3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }
    public Reservation save (Reservation reservation) {
        if(reservation.getIdReservation()==null) {
            return reservationRepository.save(reservation);
        } else {
            Optional <Reservation> reservationFound = getReservation(reservation.getIdReservation());
            if(reservationFound.isEmpty()) {
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
}
