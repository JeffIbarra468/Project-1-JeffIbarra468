package com.revature.service;

public class StringService {

	public Integer getLength(String s) {
		return s.length();
	}
	
	public String reverse(String s) {
		return (new StringBuilder(s)).reverse().toString();
	}
	
	public String toUpper(String s) {
		return s.toUpperCase();
	}
}
