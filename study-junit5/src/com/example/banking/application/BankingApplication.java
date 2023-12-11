package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.InsufficientBalanceException;

// Ctrl + Shift + O -> Organize Import
// Ctrl + Shift + F -> Formats source code
public class BankingApplication {
	public static void main(String[] args) {
		{
			// Local/Stack/Temporary/Automatic Variable
			// Reference Variable
			Account acc;
			acc = new Account("TR1", 10_000); // Heap Object
			acc.deposit(5_000);
			try {
				acc.withdraw(1_000_000);
				acc.withdraw(2_500);
			} catch (InsufficientBalanceException e) {
				System.err.println("Cannot withdraw money: %s, deficit=%12.3f".formatted(e.getMessage(),e.getDeficit()));
			}
			System.out.println(acc.toString());
		} // account is destroyed!
	}
}
