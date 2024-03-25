package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Appointment;
import com.hexaware.entity.Doctor;
import com.hexaware.entity.Patient;
import com.hexaware.util.DBUtil;

public class HospitalServiceImpl implements IHospitalService{
	
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	@Override
	public List<Appointment> fetchAllAppointment() throws SQLException {
		// TODO Auto-generated method stub
		List<Appointment> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select * from appointment");
		rs = ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("appointmentId");
			int pid=rs.getInt("patientId");
			int did=rs.getInt("doctorId");
			String date = String.valueOf(rs.getDate("appointmentDate"));
			String description = rs.getString("description");
			
			Appointment app = new Appointment(id,pid,did,LocalDate.parse(date),description);
			list.add(app);
		}
		
		return list;
	}

	@Override
	public List<Patient> fetchAllpatient() throws SQLException {
		// TODO Auto-generated method stub
		List<Patient> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select * from patient");
		rs = ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("patientId");
			String firstName=rs.getString("firstName");
			String lastName=rs.getString("lastName");
			String dob = String.valueOf(rs.getDate("dateOfBirth"));
			String gender = rs.getString("gender");
			String phone_no = rs.getString("contactNumber");
			String address = rs.getString("address");
			
			
			
			Patient p = new Patient(id,firstName,lastName,LocalDate.parse(dob),gender,phone_no,address);
			list.add(p);
		}
		
		return list;
	}

	@Override
	public List<Doctor> fetchAllDoctor() throws SQLException {
		List<Doctor> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select * from doctor");
		rs = ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("doctorId");
			String firstName=rs.getString("firstName");
			String lastName=rs.getString("lastName");
			String special = rs.getString("specialization");
			String phone_no = rs.getString("contactNumber");
			
			Doctor doc = new Doctor(id,firstName,lastName,special,phone_no);
			list.add(doc);
		}
		
		return list;
		
	}

	@Override
	public void scheduleAppointment(int pid, int did, String date, String descrip) throws SQLException {
		// TODO Auto-generated method stub
		
        con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("insert into appointment (patientId,doctorId,appointmentDate,description) values (?,?,?,?)");
		ps.setInt(1, pid);
		ps.setInt(2, did);
		ps.setDate(3, java.sql.Date.valueOf(date));
		ps.setString(4,descrip);
		ps.executeUpdate();
		
	}

	@Override
	public void updateAppointment(int id, String str, String newValue) throws SQLException {
		// TODO Auto-generated method stub
		con=DBUtil.getDBConn();
		ps = con.prepareStatement("update appointment set "+str+"=? where appointmentId =?") ;
		
           ps.setString(1,newValue);
			
			ps.setInt(2, id);
			
	
		ps.executeUpdate();
		
	}

	@Override
	public void cancelAppointment(int id) throws SQLException {
		// TODO Auto-generated method stub
		con=DBUtil.getDBConn();
		ps = con.prepareStatement("delete from appointment where appointmentId =?");
		ps.setInt(1, id);
		ps.executeUpdate();
		
		
	}
	

}
