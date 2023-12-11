package com.example.banking.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public final class Bank {
	private final int id;
	private final String name;
	private final Map<String, Customer> customers = new HashMap<>();

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Map<String, Customer> getCustomers() {
		return Collections.unmodifiableMap(customers);
	}

	public Optional<Customer> getCustomerByIdentity(String identity) {
		return Optional.ofNullable(customers.get(identity));
	}

	public void addCustomer(Customer customer) {
		var identity = customer.getIdentity();
		if (Objects.nonNull(customers.get(identity))) {
			throw new IllegalArgumentException("Customer already exists.");
		}
		customers.put(identity, customer);
	}

	public Optional<Account> getAccount(String iban) {
		return customers.values()
				        .stream()
				        .map(customer -> customer.getAccount(iban))
				        .filter(Optional::isPresent)
				        .map(Optional::get)
				        .findFirst();
	}

	public double getTotalBalance() {
		return customers.values()
				        .stream()
				        .mapToDouble(Customer::getTotalBalance)
				        .sum();
	}

	public double getTotalBalance(Class<? extends Account> clazz) {
		return customers.values()
				.stream()
				.map(Customer::getAccounts)
				.flatMap(List::stream)
				.filter(account -> account.getClass().equals(clazz))
				.mapToDouble(Account::getBalance)
				.sum();
	}
}
