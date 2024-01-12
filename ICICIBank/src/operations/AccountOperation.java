package operations;

import entity.Account;

public class AccountOperation {


	public boolean withdraw(Account account,double  amt) {
		if (amt < 0) {
			System.out.println("invalid input");
			return false;
		} else if (amt > account.getAccBal()) {
			System.out.println("not enough funds");
			return false;
			
		}

		else {
			double accBalance=account.getAccBal()  - amt;
			account.setAccBal(accBalance); 
			System.out.println(" withdraw process is successful");
			return true;
		}
	}

	public boolean deposit(Account account ,double amt) {
		if (amt < 0) {
			System.out.println("invalid input");
			return false;
		} else if (amt > account.getAccBal()) {
			System.out.println("not enough funds");
			return false;
			
			
		}

		else {
			double accBalance=account.getAccBal()  + amt;
			account.setAccBal(accBalance); 
			System.out.println("deposit process is successful");
			return true;
		}
	}
	
	public boolean transfer(Account account1,Account account2,  double amt)
	{
		if (amt < 0) {
			System.out.println("invalid input");
			return false;
		} else if (amt > account1.getAccBal()) {
			System.out.println("not enough funds");
			return false;
		}
			
			else
			{
				double accBalance=account1.getAccBal()  - amt;
				account1.setAccBal(accBalance); 
				
				double balance=account2.getAccBal();
				double newBalance=balance + amt;
				account2.setAccBal(newBalance);
				System.out.println("transfer is successful....");
				return true;
				
				
				
			}
	}
}


