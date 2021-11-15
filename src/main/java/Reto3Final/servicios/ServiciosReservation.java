/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3Final.servicios;

import Reto3Final.entidades.Reservation;
import Reto3Final.repositorios.RepositorioReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jacobo
 */
@Service
public class ServiciosReservation {
    
    @Autowired
    private RepositorioReservation metodosCrud;
    
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Reservation> getReservation(Integer id){
        return metodosCrud.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> reservationAux = metodosCrud.getReservation(reservation.getIdReservation());
            if(reservationAux.isEmpty()){
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }
}
