package userinterface;

import java.util.Scanner;

import entity.Account;
import validation.AccountValidation;
import operations.AccountOperation;

public class TestAccount {

	public static void main(String[] args) {

		Account account1 = new Account();
		Account account2 = new Account(2, "sakshi", 30000);
		AccountValidation accountValidation = new AccountValidation();
		AccountOperation accountoperation = new AccountOperation();
		Scanner sc = new Scanner(System.in);
		int num;
		String choice;

		do {

			System.out.println("Welcome to ICICI bank...");
			System.out.println("1.accept details");
			System.out.println("2.display details");
			System.out.println("3.deposit details");
			System.out.println("4.withdraw details");
			System.out.println("5.transfer details");
			System.out.println("6.change name");
			System.out.println("7.check the balance");
			System.out.println("8.exit ");

			System.out.println("Enter a number");
			num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.println("enter accno, enter name, balance");
				int accNo = sc.nextInt();

				String accHoldername = sc.next();
				double balance = sc.nextDouble();

				boolean result = accountValidation.checkAll(accNo, accHoldername, balance);
				if (result == true) {
					System.out.println("valid inputs...");
					account1.setAccNo(accNo);
					account1.setAccHolderName(accHoldername);
					account1.setAccBal(balance);
				}

				else {
					System.out.println("invalid inputs...");
				}
				break;

			case 2:
				System.out.println("=========================================");
				System.out.println("2.displaying the details...");
				System.out.println("accno is " + account1.getAccNo());
				System.out.println("accholdername is " + account1.getAccHolderName());
				System.out.println("balace is " + account1.getAccBal());
				System.out.println("=========================================");
				break;

			case 3:
				System.out.println("enter the amount to deposit");
				double amt = sc.nextDouble();
				boolean result1 = accountoperation.deposit(account2, amt);
				if (result1 == true) {
					System.out.println("deposit is successful.....");
					System.out.println("new balance is " + account2.getAccBal());
				} else {
					System.out.println("there is an error.....");

				}

				System.out.println("======================================");
				break;

			case 4:
				System.out.println("enter amount to withdraw........");

				double amt1 = sc.nextDouble();
				boolean result2 = accountoperation.withdraw(account2, amt1);
				if (result2 == true) {
					System.out.println("withdraw is successful.....");
					System.out.println("new balance is " + account2.getAccBal());
				} else {
					System.out.println("there is an error.....");

				}

				System.out.println("======================================");
				break;

			case 5:
				System.out.println("enter amount to transfer....");
				double amt2 = sc.nextDouble();
				boolean result3 = accountoperation.transfer(account1, account2, amt2);
				if (result3 == true) {
					System.out.println("transfer is successful.....");
					System.out.println("new balance is " + account1.getAccBal());
					System.out.println("new balance is " + account2.getAccBal());

				} else {
					System.out.println("there is an error.....");

				}

				System.out.println("======================================");

				break;

			case 6:
				System.out.println("enter the new name....... ");
				String name = sc.next();
				boolean result4 = accountValidation.checkName(name);
				if (result4 == true) {

					account2.setAccHolderName(name);

				}
				System.out.println(account2);
				break;

			case 7:
				System.out.println("enter the account number (1,2)");
				int accNo1 = sc.nextInt();

				if (accNo1 == 1) {

					System.out.println("balance is " + account1.getAccBal());

				} else if (accNo1 == 2) {
					System.out.println("balance is " + account2.getAccBal());

				}

				break;

			case 8:
				System.exit(0);
				break;

			default:
				System.out.println("invalid input");

			}
			System.out.println("do you want to continue? (y/Y)");
			choice = sc.next();
		} while (choice.equals("Y") || choice.equals("y"));

	}

}
