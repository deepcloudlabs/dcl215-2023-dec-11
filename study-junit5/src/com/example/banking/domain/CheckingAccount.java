package com.example.banking.domain;

// final: 1) constant: final attribute/parameter/local variable
//        2) extentability: final class, final method 
// CheckingAccount -> sub-class
// Account         -> super-class
public class CheckingAccount extends Account {
	private final double overdraftAmount;

	public CheckingAccount(final String iban,final double balance,final double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public final double withdraw(final double amount) throws InsufficientBalanceException {
		System.out.println("CheckingAccount::withdraw");
		// validation
		if (amount <= 0.) throw new IllegalArgumentException("withdraw amount must be positive.");
		// business rule
		final double maxAmount = balance+overdraftAmount;
		if ( amount > maxAmount) throw new InsufficientBalanceException(
				"Your balance does not cover your expenses", amount-balance-overdraftAmount); 
		balance = balance - amount;
		return balance;
	}


	
}
