package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, initialBalance, withdrawLimit);

		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amountWithdraw = sc.nextDouble();
		
		try {
			acc.withdraw(amountWithdraw);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Invalid Input");
		}
		
		sc.close();
	}

}
