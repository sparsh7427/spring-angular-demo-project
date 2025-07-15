CREATE TABLE DEPARTMENT (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE EMPLOYEE (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    position VARCHAR(255),
    salary DOUBLE,
    department_id VARCHAR(255),
    FOREIGN KEY (department_id) REFERENCES DEPARTMENT(id)
);
INSERT INTO DEPARTMENT (id, name, location) VALUES ('dept01', 'Human Resources', 'Building A');
INSERT INTO DEPARTMENT (id, name, location) VALUES ('dept02', 'Engineering', 'Building B');

INSERT INTO EMPLOYEE (id, name, email, position, salary, department_id) VALUES
('emp001', 'Alice Smith', 'alice.smith@example.com', 'Recruiter', 60000, 'dept01'),
('emp002', 'Bob Johnson', 'bob.johnson@example.com', 'Software Engineer', 80000, 'dept02'),
('emp003', 'Charlie Brown', 'charlie.brown@example.com', 'HR Assistant', 40000, 'dept01'),
('emp004', 'Diana Prince', 'diana.prince@example.com', 'System Architect', 90000, 'dept02');