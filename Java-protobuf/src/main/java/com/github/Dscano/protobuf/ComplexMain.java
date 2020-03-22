package com.github.Dscano.protobuf;

import example.complex.Comple.*;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {

        System.out.println("Complex example");

        DummyMessage oneDummy = newDummyMessage( 55 ,"Name" );

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        // Singular message field
        builder.setOneDummy(oneDummy);

        // repeated field
        builder.addMultipleDummy(newDummyMessage(66, "second dummy"));

        builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(69,"other dummy"),
                newDummyMessage(79,"other other dummy")
        ));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());

        //GET message.getMultipleDummyList();

    }

    public  static DummyMessage newDummyMessage (Integer id , String name){
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();

        DummyMessage message = dummyMessageBuilder.setName(name)
                .setId(id)
                .build();

        return message;

    }
}
