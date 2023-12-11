package com.example;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.example.banking.domain.Account;
import com.example.banking.domain.AccountStatus;
import com.example.banking.domain.InsufficientBalanceException;

@DisplayName("an account")
class AccountSpecification extends AbstractBaseTest {
	
	@DisplayName("cannot withdraw money with zero balance")
	@Test
	void test1() throws Throwable {
		// 1. test fixture/setup
		var account = new Account("tr1", 0.0);
		assertThrows( // Higher-Order Function: 2nd and 3rd parameters are lambda expression/pure function
				InsufficientBalanceException.class, // 3. verification 
				() -> account.withdraw(1.0),
				() -> "You cannot withdraw amount larger than the balance"
		); // 2. call exercise methods: withdraw
		// 4. test tear-down
		// No operation
	}

	@DisplayName("can deposit positive amount")
	@Test
	void test2() throws Throwable {
		var account = new Account("tr1", 0.0);
		account.deposit(1_000);
		assertAll(
			() -> assertEquals(AccountStatus.ACTIVE, account.getStatus(),() -> "Account's status should not change after deposit positive amount!"),
			() -> assertEquals(1_000, account.getBalance(),() -> "Balance should be 1000 after depositing 1000 to the zero-balanced account"),			
			() -> assertEquals("tr2", account.getIban(),() -> "Account's iban should not change after deposit positive amount!"),
			() -> assertSame(new String("tr1"), account.getIban()),
			() -> assertSame("tr1", account.getIban()),
			() -> assertSame(42, Integer.valueOf(42)), // -128..127 -> Cache
			() -> assertSame(142, Integer.valueOf(142)),
			() -> assertNotNull(account.getStatus()),
			() -> assertNull(account.getIban()),
			() -> assertArrayEquals(new int[] {1,2,3,4,5,6},new int[] {6,5,4,3,2,1}),
			() -> assertArrayEquals(new int[] {1,2,3,4,5,6},new int[] {6,5,3,2,1}),
			() -> assertArrayEquals(new int[] {1,2,3,4,5,6},new int[] {6,5,3,7,2,1}),
			() -> assertIterableEquals(List.of(1,2,3,4,5,6),Set.of(7,5,4,3,2,1)),
			() -> assertInstanceOf(String.class,account.getIban()),
			() -> assertEquals(new String("tr1"), account.getIban())
		);
	}
	
	@Test
	@Timeout(unit = TimeUnit.MILLISECONDS, value=500)
	void test3() throws Throwable {
		var account = new Account("tr1", 0.0);
		assertAll(
			() -> assertTimeout(Duration.ofMillis(100),()->account.deposit(1000)),
			() -> assertEquals(1_000,account.getBalance())
		);
	}
}
