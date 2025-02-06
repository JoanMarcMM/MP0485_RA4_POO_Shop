/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jooan
 */
public class Employee extends Person{
    
    private int employeeId;
    private String password;
    private final int EMPLOYEE_ID=123;
    private final String PASSWORD ="test";
    
    //Constructor

    public Employee(int employeeId, String password, String name) {
        super(name);
        this.employeeId = employeeId;
        this.password = password;
    }

    //Getters Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
    
    

    

    
    
    
    
    
}
