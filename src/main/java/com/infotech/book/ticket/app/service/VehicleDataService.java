package com.infotech.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.VehicleDataRepository;
import com.infotech.book.ticket.app.entities.Vehicle;

@Service
public class VehicleDataService {

	@Autowired
	private VehicleDataRepository vehicleDataRepository;

	public Vehicle createTicket(Vehicle ticket) {
		return vehicleDataRepository.save(ticket);
	}

	public Iterable<Vehicle> getAllBookedTickets() {
		return vehicleDataRepository.findAll();
	}

}
