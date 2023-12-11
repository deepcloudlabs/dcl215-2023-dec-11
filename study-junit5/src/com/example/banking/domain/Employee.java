package com.example.banking.domain;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
interface Fun { int fun();}
record EmployeeRecord(String identity, String fullname, double salary, String iban) implements Fun{

	@Override
	public int fun() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}}
// Immutable Class
public final class Employee {
	private final String identity;
	private final String fullname;
	private final double salary;
	private final String iban;

	public Employee(String identity, String fullname, double salary, String iban) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
	}

	public String getIdentity() {
		return identity;
	}

	public String getFullname() {
		return fullname;
	}

	public double getSalary() {
		return salary;
	}

	public String getIban() {
		return iban;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary + ", iban=" + iban
				+ "]";
	}

}
