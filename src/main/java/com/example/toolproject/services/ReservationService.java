package com.example.toolproject.services;

import com.example.toolproject.entities.ClientCounter;
import com.example.toolproject.entities.Reservation;
import com.example.toolproject.entities.Status;
import com.example.toolproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());

            if (e.isPresent()) {
                return reservation;
            } else {
                return reservationRepository.save(reservation);
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());

            if (e.isPresent()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }

                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }

                if (reservation.getScore() != null) {
                    e.get().setScore(reservation.getScore());
                }

                reservationRepository.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Reservation> e = reservationRepository.getReservation(id);
        if (e.isPresent()) {
            reservationRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

    public Status getReservationStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationByStatus("cancelled");
        return new Status (completed.size(),cancelled.size());
    }

    public List<Reservation> informReservationTime(String datoA, String datoB){
        SimpleDateFormat dateType = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = new Date();
        Date end = new Date();

        try{
            begin = dateType.parse(datoA);
            end= dateType.parse(datoB);
        }catch(ParseException e){
            e.printStackTrace();
        }

        if (begin.before(end)){
            return reservationRepository.informReservationTime(begin, end);
        }else{
            return new ArrayList<>();
        }
    }

    public List<ClientCounter> getTopClients(){
        return reservationRepository.getTopClient();
    }
}
