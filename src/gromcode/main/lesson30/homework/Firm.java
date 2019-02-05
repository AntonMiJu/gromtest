package gromcode.main.lesson30.homework;

import gromcode.main.lesson30.homework.DAOpackage.CustomerDAO;
import gromcode.main.lesson30.homework.DAOpackage.DepartmentDAO;

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
