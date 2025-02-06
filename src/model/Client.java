/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jooan
 */
public class Client extends Person {
    
    private int memberId;
    private Amount balance;
    final private int MEMBER_ID =456;
    final private Amount BALANCE = new Amount (50.00);
    
    //Constructor

    public Client(int memberId, double balance, String name) {
        super(name);
        this.memberId = memberId;
        Amount amount= new Amount (balance);
        this.balance = amount;
    }
    
    //Getters Setters

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Amount getBalance() {
        return balance;
    }

    public void setBalance(Amount balance) {
        this.balance = balance;
    }

    public int getMEMBER_ID() {
        return MEMBER_ID;
    }

    public Amount getBALANCE() {
        return BALANCE;
    }
    
    
}
