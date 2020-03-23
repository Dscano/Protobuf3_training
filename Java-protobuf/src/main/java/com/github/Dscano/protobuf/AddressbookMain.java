package com.github.Dscano.protobuf;

import com.example.tutorial.AddressBookProtos.*;
import example.simple.Simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class AddressbookMain {

    public static void main(String[] args) {

        AddressBook.Builder builder = AddressBook.newBuilder();

        Person.Builder builder_person = Person.newBuilder();

        //Simple instance of Person

        builder_person.setName("Pippo")
                .setId(1)
                .setEmail("pippo@gmail.com")
                .addPhones(Person.PhoneNumber.newBuilder()
                        .setType(Person.PhoneType.HOME)
                        .setNumber("0583-94568").build())
                .build();

        builder.addPeople(builder_person);

        System.out.println("Person instance:");
        System.out.println(builder.toString());

        AddressBook address = builder.build();

        //write the proto buffer binary to a file
        try {
            FileOutputStream outputStream = new FileOutputStream("addressbook.bin");
            address.writeTo(outputStream);
            outputStream.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //For reading the message from a  file
        try{
            FileInputStream fileInputStream = new FileInputStream("addressbook.bin");
            AddressBook addressFromFile = AddressBook.parseFrom(fileInputStream);
            System.out.println("Read address from file:");
            System.out.println(addressFromFile);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }



    }
}
