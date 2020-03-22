package com.github.Dscano.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {
        /*
        Simple file for work with Enums
        */
        System.out.println("Example for Enums");

        EnumMessage.Builder build = EnumMessage.newBuilder();

        build.setId(345);
        build.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumMessage message = build.build();

        System.out.println(message);
    }
}
