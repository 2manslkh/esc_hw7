package com.example.lib_hw7;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ShootTheAccountPlus {
    private int balance = 0;
    private String accountType;
    private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
    private String lastDebitTime;

    public ShootTheAccountPlus() {
    }

    public ShootTheAccountPlus(int balance, String accountType) {
        this.balance = balance;
        this.accountType = accountType;
    }

    public void deposite(int amount) {
        balance += amount;
    }

    public void addTransaction(String newType, int amount) {
        ListOfAllTransactions.add(new Transaction(newType, amount));
    }

    public void updateLastDebitTime() {
        Calendar cal = Calendar.getInstance();
        lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
    }

    public void setBalance(int amount) {
        balance = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void CreditTransaction(int amount) {

        //increase the amount
        deposite(amount);
        //add to the transaction list
        addTransaction("credit", amount);

    }


    // this method has a long method smell
    public void DebitTransaction(int amount) {

        if (sendWarning()) {

            //reduce the amount
            deposite(-amount);
            //add to the transaction list
            addTransaction("debit", amount);
            //update the last debit date
            updateLastDebitTime();

        }
    }

    // this method has a long method smell
    public void Transfer(int amount, ShootTheAccountPlus otherAccount) {

        if (sendWarning()) {

            //reduce the amount
            deposite(-amount);
            //add to the transaction list
            addTransaction("debit", amount);
            //update the last debit date
            updateLastDebitTime();
            otherAccount.CreditTransaction(amount);
        }
    }

    public boolean sendWarning() {
        if (balance < 500 && accountType == "personal") {
            System.out.println("Balance must be more than 500, please deposit");
            return true;
        } else {
            return false;
        }
    }

    class Transaction {
        private String type;
        private int amount;

        public Transaction(String newType, int newAmount) {
            this.type = newType;
            this.amount = newAmount;
        }
    }
}                                                                                                                                                                                                       
