package com.project;

import java.util.HashMap;

class AtmOperationInterfImpl implements ATMOperationInterface {
	ATM atm = new ATM();
	HashMap<Double, String> hm = new HashMap<>();

	public void depositAmount(double depositAmount) throws Exception {
		if (depositAmount % 100 == 0) {
			Thread.sleep(3000);
			System.out.println("Rs./ " + depositAmount + " Deposited Successfully");
			atm.setBalanceAmount(atm.getBalanceAmount() + depositAmount);
			hm.put(depositAmount, "Deposited");
		} else {
			System.out.println("Enter amount only in multiple of 100's");
		}
	}

	public void withdrawAmount(double withdrawAmount) throws Exception {
		if (withdrawAmount % 100 == 0) {
			if (withdrawAmount <= atm.getBalanceAmount()) {
				Thread.sleep(3000);
				System.out.println("Rs./ " + withdrawAmount + " Withdrawn Successfully");
				atm.setBalanceAmount(atm.getBalanceAmount() - withdrawAmount);
				hm.put(withdrawAmount, " Withdrawn");

			} else {
				System.out.println("Insufficient Amount");
			}

		} else {
			System.out.println("You can only withdraw multiple of 100's");
		}
	}

	public void viewBalance() {
		System.out.println("Available Balance : " + atm.getBalanceAmount());
	}

	public void miniStatement() {
		hm.forEach((i, j) -> System.out.println(i + " " + j));
	}

	public void exit() throws Exception {
		Thread.sleep(3000);
		System.out.println("Collect your ATM card thank you for visiting");
		System.exit(0);

	}

}