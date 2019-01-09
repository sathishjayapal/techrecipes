CREATE TABLE IF NOT EXISTS Employees  (
        EmployeeId INT NOT NULL PRIMARY KEY ,
        EmployeeName 		VARCHAR(50) ,
        EmployeeHomePhone   VARCHAR(20) ,
        EmployeeCountry 	VARCHAR(20) ,
        EmployeePostalCode 	VARCHAR(20),
		EmployeeCity 		VARCHAR(20),
		EmployeeAddress 	VARCHAR(100)
);