package com.project;

import java.util.HashMap;
import java.util.Scanner;

class ATM {
	private double depositAmount;
	private double withdrawAmount;
	private double balanceAmount;

//	public ATM(double depositAmount, double withdrawAmount, double balanceAmount) {
//		super();
//		this.depositAmount = depositAmount;
//		this.withdrawAmount = withdrawAmount;
//		this.balanceAmount = balanceAmount;
//	}

//	public ATM() {
//		super();
//	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

}

interface ATMOperationInterface {
	void deposit(double depositAmount) throws Exception;

	void withdraw(double withdrawAmount) throws Exception;

	void viewBalance() throws Exception;

	void viewMiniStatement() throws Exception;

	void exit() throws Exception;
}

class AtmOperationInterfImpl implements ATMOperationInterface {
	ATM atm = new ATM();
	HashMap<Double, String> hm = new HashMap<>();

	public void deposit(double depositAmount) throws Exception {
		if (depositAmount % 100 == 0) {
			Thread.sleep(3000);
			hm.put(depositAmount, " : Deposited");
			System.out.println("Rs. " + depositAmount + " /-has been deposited successfully");
			Thread.sleep(3000);
			atm.setBalanceAmount(atm.getBalanceAmount() + depositAmount);
			viewBalance();
		} else
			System.out.println("Please enter amount in multiple of 100's..");
	}

	public void withdraw(double withdrawAmount) throws Exception {
		if (withdrawAmount % 100 == 0) {
			if (withdrawAmount <= atm.getBalanceAmount()) {
				Thread.sleep(3000);
				hm.put(withdrawAmount, " : Withdraw");
				System.out.println("Collect the cash Rs. " + withdrawAmount + "/- ..");
				atm.setBalanceAmount(atm.getBalanceAmount() - withdrawAmount);
				viewBalance();

			} else
				System.out.println("Insufficient balance..");
		} else
			System.out.println("Please enter amount in multiple of 100's...");
	}

	public void viewBalance() throws Exception {
		System.out.println("Available Balance is " + atm.getBalanceAmount());
	}

	public void viewMiniStatement() throws Exception {
		hm.forEach((i, j) -> System.out.println(i + " " + j));
	}

	public void exit() throws Exception {
		Thread.sleep(3000);
		System.out.println("Collect your ATM Card..");
		System.out.println("Thanks for using SBI ATM!!");
	}

}

public class SBIBank {

	public static void main(String[] args) throws Exception {
		int accountNumber = 12345;
		int password = 123;
		ATMOperationInterface a = new AtmOperationInterfImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to SBI ATM");
		// Accepting account details
		System.out.print("Enter Account Number : ");
		int an = scan.nextInt();
		System.out.print("Enter Password : ");
		int pw = scan.nextInt();
		// Validating account details
		if (an == accountNumber && pw == password) {
			while (true) {
				System.out.println();
				Thread.sleep(3000);
				System.out.println("1.Deposit\n2.Withdraw\n3.Balance\n4.Mini Statement\n5.Exit");
				System.out.print("Enter your choice : ");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Enter amount to be Deposited : ");
					int depositAmount = scan.nextInt();
					if (depositAmount > 0) {
						a.deposit(depositAmount);
					} else
						System.out.println("Invalid amount...");
					break;
				case 2:
					System.out.print("Enter amount to be withdrawn : ");
					int withdrawAmount = scan.nextInt();
					if (withdrawAmount > 0) {
						a.withdraw(withdrawAmount);
					} else
						System.out.println("Invalid amount..");
					break;
				case 3:
					a.viewBalance();
					break;
				case 4:
					a.viewMiniStatement();
					break;
				case 5:
					a.exit();
					break;
				default:
					System.out.println("Invalid choice...");
					System.exit(0);
				}
			}
		} else
			System.out.println("Invalid Account Number");

	}

}
