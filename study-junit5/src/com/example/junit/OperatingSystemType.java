package com.example.junit;

public enum OperatingSystemType {
	WINDOWS_10("Windows 10"), WINDOWS_11("Windows 11"), LINUX(""), MAC_OS("");

	private final String osName;

	private OperatingSystemType(String osName) {
		this.osName = osName;
	}

	public String getOsName() {
		return osName;
	}

}
