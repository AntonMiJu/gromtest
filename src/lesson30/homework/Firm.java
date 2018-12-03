package lesson30.homework;

import lesson30.homework.DAOpackage.CustomerDAO;
import lesson30.homework.DAOpackage.DepartmentDAO;

import java.util.Date;

public class Firm {
    private Date dateFounded;
    private DepartmentDAO departments;
    private CustomerDAO customers;

    public Firm(DepartmentDAO departments, CustomerDAO customers) {
        this.departments = departments;
        this.customers = customers;
    }
}
