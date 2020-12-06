package com.infotech.book.ticket.app.dao;

import com.infotech.book.ticket.app.entities.Vehicle;

import org.springframework.data.repository.CrudRepository;

public interface VehicleDataRepository extends CrudRepository<Vehicle, Integer> {
}
