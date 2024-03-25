package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.dao.HospitalServiceImpl;
import com.hexaware.dao.IHospitalService;
import com.hexaware.entity.Doctor;

import com.hexaware.exception.*;

public class DoctorController {
	
	IHospitalService service = new HospitalServiceImpl();

	public List<Doctor> fetchAllDoctor() throws SQLException {
		// TODO Auto-generated method stub
		return service.fetchAllDoctor();
	}

	public boolean validateDoctor(List<Doctor> dList, int docId) throws DoctorIdNotFoundException {
		
		boolean flag = false;
		for(Doctor d : dList) {
			if(d.getDoctorId()==docId) {
				flag = true;
			}
		}
		if(flag==true)
			return flag;
		else
			throw new DoctorIdNotFoundException();
	}

}
