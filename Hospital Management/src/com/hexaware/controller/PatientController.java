package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.dao.HospitalServiceImpl;
import com.hexaware.dao.IHospitalService;
import com.hexaware.entity.*;
import com.hexaware.exception.*;

public class PatientController {
	
	IHospitalService service = new HospitalServiceImpl();

	public List<Patient> fetchAllPatient() throws SQLException {
		// TODO Auto-generated method stub
		return service.fetchAllpatient();
	}

	public boolean validatePatient(List<Patient> pList, int id) throws PatientNumberNotFoundException {
		boolean flag = false;
		for(Patient p : pList) {
			if(p.getPatientId()==id) {
				flag = true;
			}
		}
		if(flag==true)
			return flag;
		else
			throw new PatientNumberNotFoundException();
	}

}
