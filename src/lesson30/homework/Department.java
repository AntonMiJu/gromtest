package lesson30.homework;

import lesson30.homework.DAOpackage.EmployeeDAO;
import lesson30.homework.ENUMs.DepartmentType;

import java.util.HashSet;

public class Department {
    private DepartmentType type;
    private EmployeeDAO employees;

    public Department(DepartmentType type, EmployeeDAO employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public HashSet<Employee> getEmployees() {
        return employees.employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}
