package com.infotech.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import com.infotech.book.ticket.app.dao.VehicleDataRepository;
import com.infotech.book.ticket.app.entities.Vehicle;

@Service
public class VehicleDataService {

	@Autowired
	private VehicleDataRepository vehicleDataRepository;

	public Vehicle createTicket(Vehicle ticket) {
		ticket.setEntry_Time(new Date());
		ticket.setExit_Time(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10));
		return vehicleDataRepository.save(ticket);
	}

	public Iterable<Vehicle> getAllBookedTickets() {
		return vehicleDataRepository.findAll();
	}

	// public List<Vehicle> gettypeAll(VehicleType vehicleType) {
	// 	return vehicleDataRepository.findByVehicleType(vehicleType);
	// }
}
