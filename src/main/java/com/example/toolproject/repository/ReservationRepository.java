package com.example.toolproject.repository;

import com.example.toolproject.entities.Client;
import com.example.toolproject.entities.ClientCounter;
import com.example.toolproject.entities.Reservation;
import com.example.toolproject.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation> getReservationByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> informReservationTime(Date start, Date end) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(start, end);
    }

    public List<ClientCounter> getTopClient() {
        List<ClientCounter> response = new ArrayList<>();
        List<Object[]> finalReport = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i< finalReport.size(); i++){
            response.add(new ClientCounter((Long)finalReport.get(i)[1],(Client) finalReport.get(i)[0]));
        }
        return response;
    }
}
