package com.example.toolproject.repository.crudRepository;

import com.example.toolproject.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
