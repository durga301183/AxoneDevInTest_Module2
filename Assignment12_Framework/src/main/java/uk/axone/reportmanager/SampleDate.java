package uk.axone.reportmanager;

import java.util.Date;

public class SampleDate {


    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.toString().replace(" ", "_").replace(":", "_"));
    }

}


