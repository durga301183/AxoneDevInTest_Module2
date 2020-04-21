package uk.axone.framework.report;

import java.util.Date;

public class SimpleDateFormatter {

    public static void main(String[] args) {

        Date d= new Date();
        System.out.println(d);
        System.out.println(d.toString().replace(":", "_"));
    }
}
