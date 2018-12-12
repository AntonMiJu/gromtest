package lesson30.homework;

import lesson30.homework.DAOpackage.ProjectDAO;
import lesson30.homework.ENUMs.Position;

import java.util.Date;
import java.util.HashSet;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private ProjectDAO projects;

    public Employee(String firstName, Position position, Department department, ProjectDAO projects) {
        this.firstName = firstName;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public HashSet<Project> getProjects() {
        return projects.projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) return false;
        if (position != employee.position) return false;
        if (!department.equals(employee.department)) return false;
        return projects.equals(employee.projects);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + projects.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}

