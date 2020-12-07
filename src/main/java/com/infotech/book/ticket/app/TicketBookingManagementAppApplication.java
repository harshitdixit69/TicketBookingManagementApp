package com.infotech.book.ticket.app;

import com.infotech.book.ticket.app.dao.VehicleDataRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.infotech.book.ticket.app"})
@EnableJpaRepositories(basePackageClasses = VehicleDataRepository.class)
public class TicketBookingManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementAppApplication.class, args);
	}
}
