package com.infotech.book.ticket.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicleId;

	private String Vehicle_Number_Plate;

	private VehicleType vehicleType;
	private Date Entry_Time;
	private Date Exit_Time;

	public Vehicle() {
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicle_Number_Plate() {
		return Vehicle_Number_Plate;
	}

	public void setVehicle_Number_Plate(String vehicle_Number_Plate) {
		Vehicle_Number_Plate = vehicle_Number_Plate;
	}
	public Date getEntry_Time() {
		return Entry_Time;
	}

	public void setEntry_Time(Date entry_Time) {
		Entry_Time = entry_Time;
	}

	public Date getExit_Time() {
		return Exit_Time;
	}

	public void setExit_Time(Date exit_Time) {
		Exit_Time = exit_Time;
	}

	public Vehicle(Integer vehicleId, String vehicle_Number_Plate, VehicleType vehicle_Type) {
		this.vehicleId = vehicleId;
		Vehicle_Number_Plate = vehicle_Number_Plate;
		this.setVehicleType(vehicleType);
	}

}
