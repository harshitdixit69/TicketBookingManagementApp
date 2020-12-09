package com.infotech.book.ticket.app.controller;

import com.infotech.book.ticket.app.entities.Entities;
import com.infotech.book.ticket.app.entities.Vehicle;
import com.infotech.book.ticket.app.service.Userservice;
import com.infotech.book.ticket.app.service.VehicleDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class VehicleDataController {

	@Autowired
	private VehicleDataService vehicleDataService;

	@Autowired
	private Userservice userservice;

	@GetMapping(value = "/set/createuser")
	public ModelAndView createView() {
		ModelAndView modelAndView = new ModelAndView("createparking");
		modelAndView.addObject("Vehicle", new Vehicle());
		return modelAndView;
	}

	@GetMapping(value = "/")
	public ModelAndView createUser() {
		ModelAndView modelAndView = new ModelAndView("Signup");
		modelAndView.addObject("Entities", new Entities());
		return modelAndView;
	}

	@PostMapping(value = "/set/adduser")
	public ModelAndView addUser(Entities entities) {
		ModelAndView modelAndView = new ModelAndView();
		userservice.create(entities);
		modelAndView.setViewName("success");
		return modelAndView;
	}

	@PostMapping(value = "/set/createparking")
	public ModelAndView create(Vehicle vehicle) {
		ModelAndView modelAndView = new ModelAndView();
		vehicleDataService.createTicket(vehicle);

		modelAndView.setViewName("success");
		return modelAndView;
	}

	@GetMapping(value = "/get/createparking")
	public ModelAndView showUser(Vehicle vehicle) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allVehicle", vehicleDataService.getAllBookedTickets());
		modelAndView.setViewName("userinfo");
		return modelAndView;
	}

	@GetMapping(value = "/get/getALl")
	public Iterable<Vehicle> getMethodName() {
		return vehicleDataService.getAllBookedTickets();
	}

	@GetMapping(value = "/get/deleteData/{vehicleId}")
	public ModelAndView deleteTicket(@PathVariable Integer vehicleId) {
		ModelAndView modelAndView = new ModelAndView();
		vehicleDataService.deleteData(vehicleId);
		modelAndView.setViewName("success");
		return modelAndView;
	}
}
