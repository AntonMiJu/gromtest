package gromcode.main.lesson9;

import gromcode.main.lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("IBM", "USA");
        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        Checker checker = new Checker();
        //Sys.out.println(checker.companyNamesValidatedCount);
    }
}
