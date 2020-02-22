package com.company;

public class Employee implements Cloneable {
    private static final String dealership = "Funny Business Cars";
    private int employeeId;
    private String firstName;
    private String lastName;

    public Employee(int employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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


    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Employee)){
            return false;
        }else if(this == (Employee)obj){
            return true;
        }else{
            if((employeeId == ((Employee) obj).getEmployeeId())){
                return true;
            }
        }

        return false;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Employee(employeeId, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Dealer: " + dealership + "\n" +
                "Employee " + firstName + " " + lastName + "\n"+
                "ID number " + employeeId;  }
}
