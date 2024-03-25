create database hospital;
use hospital;

CREATE TABLE Patient (
    patientId INT PRIMARY KEY,
    firstName VARCHAR(20) ,
    lastName VARCHAR(20),
    dateOfBirth DATE ,
    gender VARCHAR(20),
    contactNumber VARCHAR(10),
    address VARCHAR(25)
);

CREATE TABLE  Doctor (
    doctorId INT PRIMARY KEY,
    firstName VARCHAR(20) ,
    lastName VARCHAR(20) ,
    specialization VARCHAR(20) ,
    contactNumber VARCHAR(10) 
);

CREATE TABLE  Appointment (
    appointmentId INT PRIMARY KEY auto_increment,
    patientId INT,
    doctorId INT,
    appointmentDate DATE ,
    description VARCHAR(20) ,
    FOREIGN KEY (patientId) REFERENCES Patient(patientId),
    FOREIGN KEY (doctorId) REFERENCES Doctor(doctorId)
);


-- Insert values into Patient table
INSERT INTO Patient (patientId,firstName, lastName, dateOfBirth, gender, contactNumber, address)
VALUES (1001,'John', 'Doe', '1990-01-01', 'Male', '1234567890', '123 Main St'),
       (1002,'Alice', 'Smith', '1985-10-05', 'Female', '9876543210', '456 Elm St'),
       (1003,'Michael', 'Johnson', '1978-11-15', 'Male', '5551234567', '789 Oak St'),
       (1004,'Emily', 'Brown', '1995-03-07', 'Female', '9998887776', '321 Pine St');

-- Insert values into Doctor table
INSERT INTO Doctor (doctorId,firstName, lastName, specialization, contactNumber)
VALUES (101,'Dr. Smith', 'Jones', 'Cardiologist', '1112223333'),
       (102,'Dr. Emily', 'Wilson', 'Pediatrician', '4445556666'),
       (103,'Dr. James', 'Anderson', 'Dermatologist', '7778889999'),
       (104,'Dr. Sarah', 'Taylor', 'Neurologist', '1234567890');

-- Insert values into Appointment table
INSERT INTO Appointment (patientId, doctorId, appointmentDate, description)
VALUES (1001, 101, '2024-04-01', 'Regular checkup'),
       (1002, 102, '2024-04-05', 'Vaccination'),
       (1003, 103, '2024-03-10', 'Skin treatment'),
       (1004, 104, '2024-03-25', 'ENT');

