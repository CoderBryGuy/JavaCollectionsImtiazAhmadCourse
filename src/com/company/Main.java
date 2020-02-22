package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("lion");
        animals.add("tiger");
        animals.add("wolf");
        animals.add("bear");

        System.out.println("There are " + animals.size() + " animals");
        for (String animal:animals
             ) {
            System.out.println(animal);
        }

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(123, "chevy", "silverado", 12_000d));
        vehicles.add(new Vehicle(123, "ford", "windstar", 12_500d));
        vehicles.add(new Vehicle(123, "dodge", "ram", 13_000d));

        for (Vehicle vehicle : vehicles
             ) {
            System.out.println(vehicle.toString());
            System.out.println("***************");
        }

        Customer customerA = new Customer(123, "jack", "hanna");

        try {
            customerA.setVehiclesPurchased(vehicles);
        }catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n\n\n");
        System.out.println(customerA);
    }


}
