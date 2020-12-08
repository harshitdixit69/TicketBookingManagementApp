package com.infotech.book.ticket.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import com.infotech.book.ticket.app.dao.VehicleDataRepository;
import com.infotech.book.ticket.app.entities.Vehicle;

@Component
@Service
public class VehicleDataService {
	private static final Logger logger = LoggerFactory.getLogger(VehicleDataService.class);

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

}
