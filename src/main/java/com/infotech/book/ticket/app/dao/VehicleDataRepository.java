package com.infotech.book.ticket.app.dao;

import java.util.List;

import com.infotech.book.ticket.app.entities.Vehicle;
import com.infotech.book.ticket.app.entities.VehicleType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDataRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findByVehicleType(VehicleType vehicleType);

}
