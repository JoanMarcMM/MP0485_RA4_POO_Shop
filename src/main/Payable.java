/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main;

import model.Client;

/**
 *
 * @author jooan
 */
public interface Payable {
    // Interface to pay, i've changed the entry requieremetns to fit my code.
    boolean pay(Client client, double totalAmount); 

}
