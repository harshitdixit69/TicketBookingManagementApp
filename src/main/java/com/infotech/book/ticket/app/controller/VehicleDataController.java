package com.infotech.book.ticket.app.controller;

import com.infotech.book.ticket.app.entities.Vehicle;
import com.infotech.book.ticket.app.service.VehicleDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/api/tickets")
public class VehicleDataController {

	@Autowired
	private VehicleDataService vehicleDataService;
	public static final long SEC =10;

	@GetMapping(value = "/set/createuser")
    public ModelAndView createView() {
        ModelAndView modelAndView = new ModelAndView("createparking");
        modelAndView.addObject("Vehicle", new Vehicle());
        return modelAndView;
    }

    // @GetMapping(value = "/set/setUser")
    // public ModelAndView createUser() {
    //     ModelAndView modelAndView = new ModelAndView("Signup");
    //     modelAndView.addObject("Entities", new Entities());
    //     return modelAndView;
    // }

    // @PostMapping(value = "/set/adduser")
    // public ModelAndView addUser(Entities entities) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     userservice.create(entities);
    //     modelAndView.setViewName("success");
    //     return modelAndView;
    // }

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

    // @GetMapping(value = "/get/{id}")
    // public Vehicle getVehicleDetail(@PathVariable("id") String id) {
    // return parkingservice.getDetail(id);
    // }

    @GetMapping(value = "/get/getALl")
    public Iterable<Vehicle> getMethodName() {
        return vehicleDataService.getAllBookedTickets();
    }

    // @GetMapping(value = "/get/getType/{vehicleType}")
    // public ModelAndView getListVehicleType(@PathVariable("vehicleType") VehicleType vehicleType) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.addObject("allVehicle", parkingservice.gettypeAll(vehicleType));
    //     modelAndView.setViewName("vehicletype");
    //     return modelAndView;
    // }

	// @RequestMapping(value = "/ticket/create", method = RequestMethod.POST)
	// public Vehicle createTicket(@RequestBody Vehicle ticket) {
	// 	ticket.setEntry_Time(new Date());
	// 	ticket.setExit_Time(new Date(System.currentTimeMillis()+1000*60*60*10));
	// 	return vehicleDataService.createTicket(ticket);
	// }

	// @GetMapping(value = "/ticket/alltickets")
	// public Iterable<Vehicle> getAllBookedTickets() {
	// 	return vehicleDataService.getAllBookedTickets();
	// }
}
