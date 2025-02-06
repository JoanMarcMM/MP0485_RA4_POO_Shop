/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jooan
 */
public class Amount {
   
    private double value;
    private final String currency = "$";

    public Amount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    public String getValueCurrency() {
        String valueCurrency= this.value+currency;
        return valueCurrency;
    }
    
    
}
