package oracleAcademy;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable{

	
	String name;
	String username;
	String email;
	String password;

	int count;

	private int countChars(String a, char b) {

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b) {
				count++;
			}

		}
		return count;
	}

	public String setUserName(String name) {
		return this.name.replace(' ', '.').toLowerCase();
	}

	public String setName() {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		while (a != 1) {
			name = sc.nextLine();
			a = countChars(name, ' ');

		}
		return name;

	}

	public String setEmail(String username) {
		return name.substring(0, 1).toLowerCase()
				+ name.substring(username.indexOf('.') + 1, username.length()).toLowerCase() + "@oracleacademy.Test";

	}

	public String setPassword(String username) {
		int passLength = 8;
		String s = username;
		/*
		 * for (int i = 0; i < s.length(); i++) { if(s.charAt(i) == 'n' ) { s =
		 * s.substring(i, i+1).toUpperCase() + s.substring(i, passLength); } }
		 */
		if (s.length() > passLength) {

			s = s.substring(0, 1).toUpperCase() + s.substring(1, passLength);

		}

		if (s.length() < passLength) {
			int slength = s.length();
			s = s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
			for (int i = 0; i < passLength - slength; i++) {
				s += "*";

			}

		}

		return s.replaceAll("[AEIOUaeiou]", "*");

	}

	public Employee() {
		name = setName();
		username = setUserName(name);
		email = setEmail(username);
		password = setPassword(username);

	}

	public String toString() {
		return "Employee Details \nName\t\t : " + name + "\nUsername\t : " + username + "\nEmail\t\t : " + email
				+ "\nInitial Password : " + password;
	}
}