package com.infotech.book.ticket.app.dao;

import com.infotech.book.ticket.app.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VehicleDataRepository extends JpaRepository<Vehicle, Integer> {
    // List<Vehicle> findByVehicle_Type(VehicleType Vehicle_Type);
}
