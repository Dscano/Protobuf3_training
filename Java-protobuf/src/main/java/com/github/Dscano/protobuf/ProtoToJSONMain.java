package com.github.Dscano.protobuf;

import example.simple.Simple;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import java.util.Arrays;

public class ProtoToJSONMain {

    public static void main(String[] args) {

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        builder.setId(42)  // setting an ID
                .setIsSimple(true)  // set is_simple field
                .setName("My Simple Message Name"); //set the name field

        //repeated field
        builder.addAllSampleList(Arrays.asList(4,5,6));

        System.out.println(builder.toString());

        // Print this as a JSON
        try {
            String jsonString = JsonFormat.printer().print(builder);
            System.out.println(jsonString);

            // Parse JSON into Prototbuf
            Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
            JsonFormat.parser().ignoringUnknownFields()
                    .merge(jsonString ,builder2);

            System.out.println(builder2);

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
