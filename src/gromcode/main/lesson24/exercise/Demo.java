package gromcode.main.lesson24.exercise;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> systemGeneralDAO = new GeneralDAO<>();
        Sys system1 = new Sys(11,"...");
        systemGeneralDAO.save(system1);

        System.out.println(Arrays.deepToString(systemGeneralDAO.getAll()));

        systemGeneralDAO.save(system1);

        System.out.println(Arrays.deepToString(systemGeneralDAO.getAll()));


        GeneralDAO<Tool> toolGeneralDAO = new GeneralDAO<>();
        Tool tool1 = new Tool("rrr","ppp");
        toolGeneralDAO.save(tool1);

        System.out.println(Arrays.deepToString(toolGeneralDAO.getAll()));

        GeneralDAO<Order> orderGeneralDAO = new GeneralDAO<>();
    }
}
