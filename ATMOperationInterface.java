package com.project;

interface ATMOperationInterface {
	void depositAmount(double depositAmount) throws Exception;

	void withdrawAmount(double withdrawAmount) throws Exception;

	void viewBalance() throws Exception;

	void miniStatement() throws Exception;

	void exit() throws Exception;

}
