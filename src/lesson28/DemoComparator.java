package lesson28;

import lesson28.task2.IsActiveComparator;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability = new Capability(1001,"test","rrr",true,new Date());
        Capability capability2 = new Capability(1005,"test","rrr",false,new Date());
        Capability capability3 = new Capability(900,"test","rrr",true,new Date());
        Capability capability4 = new Capability(900,"test","rrr",false,new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);


        Comparator<Capability> comparator = new Comparator<Capability>() {
            @Override
            public int compare(Capability o1, Capability o2) {
                if (!o1.getChannelName().equals(o2.getChannelName()))
                    return o1.getChannelName().compareTo(o2.getChannelName());
                if (!o1.getFingerPrint().equals(o2.getFingerPrint()))
                    return o1.getFingerPrint().compareTo(o2.getFingerPrint());
                if (!o1.getDateCreated().equals(o2.getDateCreated()))
                    return o1.getDateCreated().compareTo(o2.getDateCreated());
                return 0;
            }
        };
    }
}
