package com.company;

import java.util.ArrayList;

public class Customer implements Cloneable {
    private int customerID;
    private String firstName;
    private String lastName;
    private Boolean boughtVehicle = false;
    private ArrayList<Vehicle> vehiclesPurchased;

    public Customer(int customerID, String firstName, String lastName) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getBoughtVehicle() {
        return boughtVehicle;
    }

    public void setBoughtVehicle(Boolean boughtVehicle) {
        this.boughtVehicle = boughtVehicle;
    }

    public ArrayList<Vehicle> getVehiclesPurchasedDeepCopy() throws CloneNotSupportedException {

        ArrayList<Vehicle> newVehiclesPurchasedList = new ArrayList<>();

        for (Vehicle vehicle: vehiclesPurchased
             ) {
                newVehiclesPurchasedList.add(vehicle.clone());
        }

        return newVehiclesPurchasedList;
    }

    public void setVehiclesPurchased(ArrayList<Vehicle> vehiclesPurchased) throws CloneNotSupportedException{

        if(this.vehiclesPurchased == null) {

            this.vehiclesPurchased = new ArrayList<>();

            for (Vehicle vehicle : vehiclesPurchased
            ) {
                if(vehicle.clone() != null) {
                    this.vehiclesPurchased.add(vehicle.clone());
                }
            }

        }else {

            ArrayList<Vehicle> tempList = new ArrayList<>();

            for (Vehicle vehicle: vehiclesPurchased
                 ) {
                tempList.add(vehicle.clone());
            }

            this.vehiclesPurchased.addAll(tempList);
        }
    }

    public void addVehiclePurchase(Vehicle newVehicle){

        if(!vehiclesPurchased.contains(newVehicle)){
            if(vehiclesPurchased.size() == 0){
                boughtVehicle = true;
            }

            vehiclesPurchased.add(newVehicle);
        }else {
            System.out.println("vehicle already in list");
        }

    }

    public void addVehiclePurchase(int vin, String make, String model, double price){
        addVehiclePurchase(new Vehicle(vin, make, model, price));
    }

    @Override
    public boolean equals(Object obj) {

        Customer customerB;

        if(!(obj instanceof Customer)){
            return false;
        }else if(this == (Customer)obj){
            return true;
        }else {
            customerB = (Customer) obj;
            if(customerID == customerB.getCustomerID()
                && firstName.equals(customerB.getFirstName())
                && lastName.equals(customerB.getLastName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder customerString = new StringBuilder("Customer" +
                "customerID=" + customerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", boughtVehicle=" + boughtVehicle +
                ", vehiclesPurchased: \n");

        for (Vehicle vehicle : vehiclesPurchased
             ) {
             customerString.append(vehicle.toString()).append("\n").append("******************\n");
        }

        return customerString.toString();
    }
}
