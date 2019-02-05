package gromcode.main.lesson31;

import java.util.HashMap;
import java.util.Map;

public class MapIntro {
    public static void main(String[] args) {
        Map<String, Building> map = new HashMap<>();

        Building building = new Building("school..",5);
        Building building1 = new Building("hospital..",5);
        map.put("TTT222", building);
        map.put("PG55PR", building1);

        System.out.println(map);

        System.out.println(map.keySet());

        System.out.println(map.values());

        System.out.println(map.get("PG55PR"));

        map.remove("TTT222");
        System.out.println(map);

        map.put("PG55PR", building);
    }
}
