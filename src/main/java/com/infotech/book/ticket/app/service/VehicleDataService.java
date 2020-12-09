package com.infotech.book.ticket.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import com.infotech.book.ticket.app.dao.VehicleDataRepository;
import com.infotech.book.ticket.app.entities.Vehicle;

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

	@Cacheable(value = "vehicleCache")
	public Iterable<Vehicle> getAllBookedTickets() {
		return vehicleDataRepository.findAll();
	}

	@CacheEvict(value = "vehicleCache", key = "#vehicleId")
	public void deleteData(Integer vehicleId) {
		vehicleDataRepository.deleteById(vehicleId);
	}

}
