package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.entity.Appointment;
import com.hexaware.entity.Doctor;
import com.hexaware.entity.Patient;

public interface IHospitalService {

	List<Appointment> fetchAllAppointment() throws SQLException;

	List<Patient> fetchAllpatient() throws SQLException;

	List<Doctor> fetchAllDoctor() throws SQLException;

	void scheduleAppointment(int pid, int did, String date, String descrip) throws SQLException;

	void updateAppointment(int id, String str, String newValue) throws SQLException;

	void cancelAppointment(int id) throws SQLException;

}
