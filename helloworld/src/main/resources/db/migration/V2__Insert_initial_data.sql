-- Insert sample departments
INSERT INTO department (name) VALUES ('HR');
INSERT INTO department (name) VALUES ('IT');

-- Insert sample employees with department associations
INSERT INTO employee (name, department_id) VALUES ('John Doe', 1);
INSERT INTO employee (name, department_id) VALUES ('Jane Smith', 2);
INSERT INTO employee (name, department_id) VALUES ('Bob Johnson', 1);