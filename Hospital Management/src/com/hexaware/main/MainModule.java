package com.hexaware.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hexaware.controller.*;
import com.hexaware.entity.*;
import com.hexaware.exception.*;



public class MainModule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppointmentController ac = new AppointmentController();
		PatientController pc = new PatientController();
		DoctorController dc = new DoctorController();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("******HOSPITAL MANAGEMENT******");
			System.out.println("1. Get apppointments by Id");
			System.out.println("2. Get Appointments for patient");
			System.out.println("3. Get Appointments for doctor");
			System.out.println("4. schedule appointment");
			System.out.println("5. update appointment");
			System.out.println("6. cancel appointment");
			System.out.println("0. Exit");
			System.out.println("******************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you");
				break;
			}
			switch(input) {
			case 1:
				
				try {
					List<Appointment> list = ac.fetchAllAppointment();
					
					System.out.println("enter the appointment id:");
					int id = sc.nextInt();
					
					boolean validation = ac.AppointmentValidation(list,id);
					
					if(validation==true) {
						ac.getAppoinmentById(list,id);
					}
				} catch (SQLException | AppointmentNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 2:
				
				try {
					List<Appointment> list = ac.fetchAllAppointment();
					List<Patient> pList = pc.fetchAllPatient();
					
					
					System.out.println("enter the patient id:");
					int id = sc.nextInt();
					
					boolean validate = pc.validatePatient(pList,id);
					
					if(validate ==true) {
						ac.getAppointmentForPatient(list,id);
					}
					
				} catch (SQLException | PatientNumberNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 3:
				
				try {
					List<Appointment> list = ac.fetchAllAppointment();
					List<Doctor> dList = dc.fetchAllDoctor();
					
					
					System.out.println("enter the doctor id:");
					int docId = sc.nextInt();
					
					boolean validate = dc.validateDoctor(dList,docId);
					
					if(validate ==true) {
						ac.getAppointmentForDoctor(list,docId);
					}
					
				} catch (SQLException | DoctorIdNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 4:
				
				try {
					
					System.out.println("Enter Patient Id :");
					int pid = sc.nextInt();
					
					System.out.println("Enter Doctor Id :");
					int did = sc.nextInt();
					
					System.out.println("Enter the Appointment Date :");
					String date = sc.next();
					
					
					System.out.println("Enter the Description :");
					sc.nextLine();
					String descrip = sc.nextLine();
					
					ac.scheduleAppointment(pid,did,date,descrip);
					
					System.out.println("Appointment Scheduled :-) ");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 5:
				try {
				System.out.println("Enter Appointment Id");
				int id = sc.nextInt();
				
				System.out.println("Enter the attribute u want to update:[appointmentDate/description]");
				String str = sc.next();
				sc.nextLine();
				String newValue = " ";
				if(str.equals("appointmentDate")) {
					System.out.println("Enter ur appointment date");
					newValue=sc.nextLine();
					ac.updateAppointment(id,str,newValue);
				}
				else if(str.equals("description")) {
					System.out.println("Enter description");
					newValue =sc.nextLine();
					ac.updateAppointment(id,str,newValue);
				}
				else {
					System.out.println("Please enter a valid input !!!!");
				}
				
				System.out.println("Updated Successfully :)");
				
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 6:
				try {
					List<Appointment> list2 = ac.fetchAllAppointment();
					System.out.println("Enter Appointment Id:");
					int id = sc.nextInt();
					boolean validation = ac.AppointmentValidation(list2, id);
					if(validation==true) {
						ac.cancelAppointent(id);
					}
					System.out.println("Appointment Canceled :)");
					
				} catch (SQLException | AppointmentNotFoundException e) {
					e.printStackTrace();
				}
			
			}
			
		}

	}

}
