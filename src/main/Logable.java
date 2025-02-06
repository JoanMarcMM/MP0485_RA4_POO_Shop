/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main;

import model.Employee;

/**
 *
 * @author jooan
 */
public interface Logable {
    // Interface to log in, i've changed the entry requirements to fit my code
    //I will ask for the password and user inside the method. Im asking for the employee
    //so that i can get the info of the employee to compare the password and user
    boolean login(Employee employee);

}
