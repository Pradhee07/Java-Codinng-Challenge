package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.entity.*;
import com.hexaware.exception.*;

import com.hexaware.dao.*;

public class AppointmentController {
	
	IHospitalService aservice = new HospitalServiceImpl();

	public List<Appointment> fetchAllAppointment() throws SQLException {
		// TODO Auto-generated method stub
		return aservice.fetchAllAppointment();
	}

	public boolean AppointmentValidation(List<Appointment> list, int id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Appointment a : list) {
			if(a.getAppointmentId()==id) {
				flag = true;
			}
		}
		if(flag==true)
			return flag;
		else
			throw new AppointmentNotFoundException();
	}

	public void getAppoinmentById(List<Appointment> list, int id) {
		// TODO Auto-generated method stub
		for(Appointment a:list) {
	    	if(a.getAppointmentId()==id) {
	    	   System.out.println(String.format("%-20s%-20s%-20s%-20s%s","Appointment Id","Patient Id","Doctor Id","Appointment date","Description"));
		       System.out.println(String.format("%-20d%-20d%-20d%-20s%s",a.getAppointmentId(),a.getPatientId(),a.getDoctorId(),a.getAppointmentDate(),a.getDescription()));
	    	   System.out.println();
	    	   break;
	    	}
	    }
		
	}

	public void getAppointmentForPatient(List<Appointment> list, int id) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%-20s%-20s%-20s%-20s%s","Appointment Id","Patient Id","Doctor Id","Appointment date","Description"));
		for(Appointment a:list) {
	    	if(a.getPatientId()==id) {
	    	   
		       System.out.println(String.format("%-20d%-20d%-20d%-20s%s",a.getAppointmentId(),a.getPatientId(),a.getDoctorId(),a.getAppointmentDate(),a.getDescription()));
	    	   System.out.println();

	    	}
	    }
		
	}
	

	public void getAppointmentForDoctor(List<Appointment> list, int docId) {
		// TODO Auto-generated method stub
		
		 System.out.println(String.format("%-20s%-20s%-20s%-20s%s","Appointment Id","Patient Id","Doctor Id","Appointment date","Description"));
		for(Appointment a:list) {
	    	if(a.getDoctorId()==docId) {
	    	  
		       System.out.println(String.format("%-20d%-20d%-20d%-20s%s",a.getAppointmentId(),a.getPatientId(),a.getDoctorId(),a.getAppointmentDate(),a.getDescription()));
	    	   System.out.println();
	    	}
	    }
	}

	

	public void scheduleAppointment(int pid, int did, String date, String descrip) throws SQLException {
		// TODO Auto-generated method stub
		aservice.scheduleAppointment(pid,did,date,descrip);
		
		
	}

	public void updateAppointment(int id, String str, String newValue) throws SQLException {
		// TODO Auto-generated method stub
		aservice.updateAppointment(id,str,newValue);
		
	}

	public void cancelAppointent(int id) throws SQLException {
		// TODO Auto-generated method stub
		aservice.cancelAppointment(id);
		
	}

	

}
