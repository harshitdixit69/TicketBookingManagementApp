package com.infotech.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.infotech.book.ticket.app.dao.VehicleDataRepository;
import com.infotech.book.ticket.app.entities.Vehicle;
import com.infotech.book.ticket.app.entities.VehicleType;

@Component
@Service
public class VehicleDataService {
	@Autowired
	private VehicleDataRepository vehicleDataRepository;

	public Vehicle createTicket(Vehicle ticket) {
		ticket.setEntry_Time(new Date());
		ticket.setExit_Time(new Date(System.currentTimeMillis() + 1000 * 30));
		return vehicleDataRepository.save(ticket);
	}

	public Iterable<Vehicle> getAllBookedTickets() {
		return vehicleDataRepository.findAll();
	}

	public void deleteData(Integer vehicleId) {
		vehicleDataRepository.deleteById(vehicleId);
	}

	public List<Vehicle> gettypeAll(VehicleType vehicleType) {
		return vehicleDataRepository.findByVehicleType(vehicleType);
	}

}
