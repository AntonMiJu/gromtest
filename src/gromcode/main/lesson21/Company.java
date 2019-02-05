package gromcode.main.lesson21;

public class Company {
    private int numberOfEmployees;
    private String name;

    private static String licence;

    private static int maxNumbersOfEmployees;

    static {
        System.out.println("Code block is called");
        init();
    }

    public Company(int numberOfEmployees, String name) throws Exception{
        if (numberOfEmployees>maxNumbersOfEmployees)
            throw new Exception("Company can have max "+maxNumbersOfEmployees+" employees");
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
    }

    private static void init(){
        maxNumbersOfEmployees = 100;
    }

    public static void validate() throws Exception{
        if (!licence.equals("TTT11"))
            throw new Exception("Wrong licence "+licence);
    }

    public static void setLicence(String licence) {
        Company.licence = licence;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public String getLicence() {
        return licence;
    }
}
