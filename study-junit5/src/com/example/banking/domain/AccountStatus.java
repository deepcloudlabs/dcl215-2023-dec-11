package com.example.banking.domain;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public enum AccountStatus {
	ACTIVE(100), CLOSED(150), BLOCKED(175);
	private final int bddkCode;

	private AccountStatus(int bddkCode) {
		this.bddkCode = bddkCode;
	}

	public int getBddkCode() {
		return bddkCode;
	}
	
}
