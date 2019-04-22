package com.example.lib_hw7;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Transaction {
	private String type;
	private int amount;
	
	public Transaction (String newType, int newAmount) {
		this.type = newType;
		this.amount = newAmount;
	}
}

public class AccountSmell {
  private int balance = 0;
  private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
  private String lastDebitTime;
  private String lastCreditTime;
  
  public AccountSmell () {
  }

  public AccountSmell (int balance) {
    this.balance = balance;
  }
  
  public void deposite (int amount) {
    balance += amount;
  }
    
  public void setBalance (int amount) {
    balance = amount;
  }
  
  public int getBalance () {
    return balance;
  }

  public void addTransaction(String newType, int amount){
      ListOfAllTransactions.add(new Transaction(newType, amount));
  }

  public void updateCalendar(){
      Calendar cal = Calendar.getInstance();
      lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
  }
  
// this method has a long method smell, it is doing too many things
  public void CreditTransaction(int amount) {
	  //reduce the amount 1
	  deposite(amount);
	  
	  //add to the transaction list 2
	  addTransaction("credit",amount);
	  
	  //update the last debit date 3 DIFFERENT THINGS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	  updateCalendar();
  }
  
  // this method has a long method smell
  public void DebitTransaction(int amount) {
	  //reduce the amount
//	  balance = balance - amount;
	  deposite(-amount);

	  //add to the transaction list
	  addTransaction("debit", amount);
	  
	  //update the last debit date
      updateCalendar();

  }

}                                                                                                                                                                                                       
