package com.infotech.book.ticket.app.controller;

import java.util.Date;

import com.infotech.book.ticket.app.entities.Vehicle;
import com.infotech.book.ticket.app.service.VehicleDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tickets")
public class VehicleDataController {

	@Autowired
	private VehicleDataService vehicleDataService;
	public static final long SEC =10;

	@RequestMapping(value = "/ticket/create", method = RequestMethod.POST)
	public Vehicle createTicket(@RequestBody Vehicle ticket) {
		ticket.setEntry_Time(new Date());
		ticket.setExit_Time(new Date(System.currentTimeMillis()+1000*60*60*10));
		return vehicleDataService.createTicket(ticket);
	}

	@GetMapping(value = "/ticket/alltickets")
	public Iterable<Vehicle> getAllBookedTickets() {
		return vehicleDataService.getAllBookedTickets();
	}
}
