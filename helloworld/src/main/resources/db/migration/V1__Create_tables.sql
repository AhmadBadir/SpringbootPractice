-- Create the department table
CREATE TABLE department (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL
);

-- Create the employee table with the foreign key to department
CREATE TABLE employee (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    department_id INTEGER,
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE SET NULL
);