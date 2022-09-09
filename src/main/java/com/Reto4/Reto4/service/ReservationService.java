/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.service;

import com.Reto4.Reto4.entity.Reservation;
import com.Reto4.Reto4.repository.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class ReservationService {

    /**
     * Instancia del repositorio
     */
    @Autowired
    private ReservationRepository repository;

    /**
     * Metodo para obtener las reservaciones
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return repository.findAll();
    }

    /**
     * metodo para obtener una reservación por id
     *
     * @param id
     * @return
     */
    public Reservation getReservationById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * metodo para guardar una reservación
     *
     * @param reservation
     * @return
     */
    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }

    /**
     * metodo para actualizar una reservación
     *
     * @param reservation
     * @return
     */
    public Reservation updateReservation(Reservation reservation) {
        Reservation existReservation = getReservationById(reservation.getIdReservation());
        existReservation.setIdReservation(reservation.getIdReservation());
        existReservation.setStartDate(reservation.getStartDate());
        existReservation.setDevolutionDate(reservation.getDevolutionDate());
        existReservation.setStatus(reservation.getStatus());
        return repository.save(existReservation);

    }

    /**
     * metodo para eliminar una reservación
     *
     * @param id
     */
    public void deleteReservation(int id) {
        repository.deleteById(id);
    }

}
