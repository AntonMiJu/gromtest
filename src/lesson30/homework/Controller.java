package lesson30.homework;

import lesson30.homework.ENUMs.DepartmentType;
import lesson30.homework.ENUMs.Position;

import java.util.HashSet;

public class Controller {
    private HashSet<Customer> customers;
    private HashSet<Department> departments;
    private HashSet<Employee> employees;
    private HashSet<Project> projects;

    public Controller(HashSet<Customer> customers, HashSet<Department> departments, HashSet<Employee> employees, HashSet<Project> projects) {
        this.customers = customers;
        this.departments = departments;
        this.employees = employees;
        this.projects = projects;
    }

    public HashSet<Employee> employeesByProject(String projectName) {
        HashSet<Employee> result = null;
        for (Employee em : employees) {
            if (em.getProjects().projects.contains(projectName)) {
                result.add(em);
            }
        }
        return result;
    }

    public HashSet<Project> projectByEmployees(Employee employee) {
        return employee.getProjects().projects;
    }

    public HashSet<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        HashSet<Employee> result = null;
        Department department = null;
        for (Department dp : departments) {
            if (dp.getType().equals(departmentType)) {
                department = dp;
            }
        }
        for (Employee em : department.getEmployees().employees) {
            if (em.getProjects().projects.size() == 0)
                result.add(em);
        }
        return result;
    }

    public HashSet<Employee> employeesWithoutProject() {
        HashSet<Employee> result = null;
        for (Employee em : employees) {
            if (em.getProjects().projects.size() == 0)
                result.add(em);
        }
        return result;
    }

    public HashSet<Employee> employeesByTeamLead(Employee lead) {
        HashSet<Employee> result = null;
        for (Project pr : lead.getProjects().projects) {
            result.addAll(employeesByProject(pr.getName()));
        }
        return result;
    }

    public HashSet<Employee> teamLeadsByEmployee(Employee employee) {
        HashSet<Employee> result = null;
        for (Project pr : employee.getProjects().projects){
            for (Employee em : employeesByProject(pr.getName())){
                if (em.getPosition().equals(Position.TEAM_LEAD))
                    result.add(em);
            }
        }
        return result;
    }

    public HashSet<Employee> employeesByProjectEmployee(Employee employee) {
        HashSet<Employee> result = null;
        for (Project pr : employee.getProjects().projects){
            result.addAll(employeesByProject(pr.getName()));
        }
        return result;
    }

    public HashSet<Project> projectsByCustomer(Customer customer) {
        HashSet<Project> result = null;
        for (Project pr : projects) {
            if (pr.getCustomer().equals(customer))
                result.add(pr);
        }
        return result;
    }

    public HashSet<Employee> employeesByCustomerProjects(Customer customer) {
        HashSet<Employee> result = null;
        for (Project pr : projectsByCustomer(customer)){
            result.addAll(employeesByProject(pr.getName()));
        }
        return result;
    }
}
