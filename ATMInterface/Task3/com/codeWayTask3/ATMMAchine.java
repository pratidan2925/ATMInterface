package com.codeWayTask3;

import java.util.Scanner;

 interface User {	
	 void deposit(double amount) ;
	 void cheakBalance() ;
		
	boolean withdraw(double amount);
	}

class UserBankAccount {
	private double balance ;
	
	public UserBankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	public void deposite(double amount) {
		balance += amount;
	}
	
	public boolean withdraw(double amount) {
		if(amount > balance) {
		System.out.println("Low Balance ");
			return false;
		}else {
			balance -= amount ;
			System.out.println("Withdrawal Sucessful .Remaining balance :" + balance);
			return true;
		}
	}
}

 class ATM implements User{

	private UserBankAccount userAccount;
	
	public ATM(UserBankAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public void deposit(double amount) {
		userAccount.deposite(amount);
		System.out.println("Deposite Sucessful . New Balance :" + userAccount.getBalance());
		
	}

	@Override
	public void cheakBalance() {
	System.out.println("Current Balance : " + userAccount.getBalance());
		
	}

	@Override
	public boolean withdraw(double amount) {
		
		return userAccount.withdraw(amount);
	}
	
	
	public void displayMenu() {
		System.out.println("=============ATM MENU===============");
		System.out.println("1.Check Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Exit");
	}
	
	
	public void processUserChoice(int choice , Scanner sc) {
		switch (choice) {
		case 1:
			cheakBalance();
			break;
			
		case 2:
			System.out.println("Enter deposit amount :");
			double depositeAmount = sc.nextDouble();
			deposit(depositeAmount);
			break;
			
		case 3:
			System.out.println("Enter Withdrawal amount :");
			double withdrawalAmount = sc.nextDouble();
			withdraw(withdrawalAmount);
			break ;
			
		case 4:
			System.out.println("Thank you for using the ATM");
			System.exit(0);
			break;
			
			
		default:
			System.out.println("Invalid Choice");
		}
	}
}
 
 public  class ATMMAchine{
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 UserBankAccount userAccount = new UserBankAccount(10000.0);
		 
		 User user = new ATM(userAccount);
		 
		 while(true) {
			 ((ATM) user).displayMenu();
			 
			 System.out.println("Enter your Choice :");
			 int choice = sc.nextInt();
			 
			 ((ATM) user).processUserChoice(choice, sc);
		 }
		 
		
	}
	 
 }