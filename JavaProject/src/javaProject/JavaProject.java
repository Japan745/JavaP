/**
 * 
 */
package javaProject;

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Japan Patel
 *
 */
public class JavaProject extends User{

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	//TransferAmount =  is for amount to be transferred to other bank account
	//flag = to check the beneficiary account no (0 = invalid and 1 = valid)
	static String TransferAmount="";
	static int flag=0;
	public static void main(String[] args) throws IOException {
		/**
		 * options = will fetch the input from user.
		 * uid = to store user unique id.
		 * choice = will fetch the input from existing user.
		 * fname = store first name
		 * lname = store last name
		 * address = store address
		 * email = store email
		 * contact no = store contact no
		 * dob = store dob
		 * sin = store sin no
		 * acctype = will store the decision of user; whether user want to create savings account or current account or both.
		 */
		int options;
		String uid="";
		do {
			options =Integer.parseInt(JOptionPane.showInputDialog("Enter 1. If you are a existing User.\r\n "
			+ "Enter 2. If you are a new User.\r\n"
			+ "Enter 0. Exit\n"));
			if(options!=0 && options!=2)
				uid = JOptionPane.showInputDialog("Enter your user id");
				uid=uid+".txt";
			File checkUser = new File(uid);
			if(options==1 && checkUser.exists()) 
			{
				int choice=-1;
				while(choice!=0)
				{
					choice = Integer.parseInt(JOptionPane.showInputDialog("Enter 1. 	Display their current balance \r\n"
							+ "Enter 2. Deposit money  \r\n"
							+ "Enter 3. Draw money and (charge a fee)\r\n"
							+ "Enter 4. Transfer money to other accounts within the bank \r\n"
							+ "Enter 5. Pay utility bills  \r\n"
							+ "Enter 6. To create new account type\r\n"
							+ "Enter 7. To view your bank details \r\n"
							+ "Enter 8. To edit your bank details\r\n"
							+ "Enter 9. To Delete Account\r\n"
							+ "Enter 0. To go back\n"));
					if(choice==1)
					{
						checkBalance(uid);
					
					}
					else if(choice==2) 
					{
						depositMoney(uid);
					}
					else if(choice==3)
					{
						drawMoney(uid);
					}
					else if(choice==4)
					{
						moneyTransfer(uid);
					}
					else if(choice==5)
					{
						payUtilityBills(uid);
					}
					else if(choice==6)
					{
						checkAccount(uid);
					}	
					else if(choice==7)
					{
						viewDetails(uid);
					}
					else if(choice==8)
					{
						editDetails(uid);
					}
					else if(choice==9)
					{
						deleteAccount(uid);
					}
				}
			}
			else if(options==2) 
			{
				//User account will be created here. and object.save function will generate a file for that user
				User u;
				String fname,lname,DOB,address,Email;
				long contact_no,sin_no;
				String acctype_choice;
				fname = JOptionPane.showInputDialog("Enter your First Name ");
				lname = JOptionPane.showInputDialog("Enter your Last Name ");
				address = JOptionPane.showInputDialog("Enter your address ");
				DOB  = JOptionPane.showInputDialog("Enter your Date of Birth ");
				Email  = JOptionPane.showInputDialog("Enter your Email ");
				contact_no = Long.parseLong(JOptionPane.showInputDialog("Enter your contact no "));
				sin_no = Long.parseLong(JOptionPane.showInputDialog("Enter your SIN no "));
				acctype_choice = JOptionPane.showInputDialog("Enter 1. To create a saving account \n"
						+ "Enter 2. To create a current account \n"
						+ "Enter 3. To create both ");
				u=new User(fname,lname,address,DOB,Email,contact_no,acctype_choice,sin_no);
				u.save();
				JOptionPane.showMessageDialog(null, "Your User id : "+u.getUser_id());
			}
			else if(options==0 || options==2)
			{
				continue;
			}
			else {
				JOptionPane.showMessageDialog(null,"INVALID USER ID");
			}
		}while(options!=0);
	}

	private static void deleteAccount(String uid) {
		
	}

	private static void editDetails(String uid) throws IOException {
		/**
		 * edit = to get input from user for changing his detail
		 * newvalue = will store new value which user want to store
		 * type = reflects the data that user want to change(like type = First name will change the first name of user)
		 */
		int edit = -1;
		do {
			edit = Integer.parseInt(JOptionPane.showInputDialog("Enter 1. To change your First name.\r\n "
					+ "Enter 2. To change your Last name.\r\n"
					+ "Enter 3. To change you Date of Birth\r\n"
					+ "Enter 4. To change your Contact no \r\n"
					+ "Enter 5. To change your SIN no \r\n"
					+ "Enter 6. To change your address \r\n"
					+ "Enter 7. To change your Email \r\n"
					+ "Enter 0. Go back \r\n"));
			if(edit==1)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter First Name\n");
				String type =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "First Name Updated Successfully");
			}else if(edit==2)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Last Name\n");
				String type =  "Last Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Last Name Updated Successfully");
				
			}else if(edit==3)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Date of Birth\n");
				String type =  "DOB";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Date of Birth Updated Successfully");
				
			}else if(edit==4)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Contact no\n");
				String type =  "Contact no";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Contact no Updated Successfully");
				
			}else if(edit==5)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new SIN no\n");
				String type =  "SIN no";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "SIN no Updated Successfully");
			}
			else if(edit==6)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Address\n");
				String type =  "Address";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Address Updated Successfully");
			}
			else if(edit==7)
			{
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Email\n");
				String type =  "Email";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Email Updated Successfully");
			}
		}while(edit!=0);
	}

	private static void viewDetails(String uid) throws IOException {
		/**
		 * Method will help user to check his bank details
		 */
		File file = new File(uid);
		if(file.exists())
		{
			Scanner in = new Scanner(file);
			String filecontents = "";
			while(in.hasNext())
			{
				filecontents = filecontents + in.nextLine() + "\n";
			}
			in.close();
			JOptionPane.showMessageDialog(null,"----------USER DETAILS-----------\n"+ filecontents);
		}else
		{
			JOptionPane.showMessageDialog(null, "INVALID USER ID");
		}
	}

	private static void payUtilityBills(String User_id) throws IOException {
		/**
		 * Method will help user to pay his utility bills
		 * choice = store the input given by user for utility bill
		 */
		String choice = JOptionPane.showInputDialog("Enter 1. To pay Hydro Bill"
				+"\nEnter 2. To pay Water Bill"
				+"\nEnter 3. To pay Cable Bill"
				+"\nEnter 4. To pay Internet Bill"); 
		if(Integer.parseInt(choice)==1)
		{
			String acc = JOptionPane.showInputDialog("Enter Beneficary Account no :");
			if(Integer.parseInt(acc)!=0)
			{
				drawMoney(User_id);
				JOptionPane.showMessageDialog(null, "Your Payment is Successfull");
			}
		}
		else if(Integer.parseInt(choice)==2)
		{
			String acc = JOptionPane.showInputDialog("Enter Beneficary Account no :");
			if(Integer.parseInt(acc)!=0)
			{
				drawMoney(User_id);
				JOptionPane.showMessageDialog(null, "Your Payment is Successfull");
			}
		}
		else if(Integer.parseInt(choice)==3)
		{
			String acc = JOptionPane.showInputDialog("Enter Beneficary Account no :");
			if(Integer.parseInt(acc)!=0)
			{
				drawMoney(User_id);
				JOptionPane.showMessageDialog(null, "Your Payment is Successfull");
			}
		}
		else if(Integer.parseInt(choice)==4)
		{
			String acc = JOptionPane.showInputDialog("Enter Beneficary Account no :");
			if(Integer.parseInt(acc)!=0)
			{
				drawMoney(User_id);
				JOptionPane.showMessageDialog(null, "Your Payment is Successfull");
			}
		}
		
	}

	private static void moneyTransfer(String User_id) throws IOException {
		/**
		 * Methods will help user to tranfer money to beneficiary account
		 */
		String BeneficiaryAccNo = JOptionPane.showInputDialog("Enter Beneficiary Account no :\n");
		File directory = new File("C://Users//Japan Patel//Desktop//JProject//JavaP//JavaProject");
		File files[] = null;
        if(directory.isDirectory())
        {
            files = directory.listFiles();
            for(File dirFiles:files)
            {
                    if(dirFiles.getName().endsWith(".txt"))
                    {
                    	String filename = dirFiles.getName();
                       fetchBeneficiaryDetails(User_id,BeneficiaryAccNo,filename);
                    }
            }

        }
        if(flag==0)
        {
        	JOptionPane.showMessageDialog(null,"--- INVALID ACCOUNT NO --- \n Please Check Account no again");
        }
	}
	//}

	private static void fetchBeneficiaryDetails(String user_id, String beneficiaryAccNo, String filename) throws IOException {
		/**
		 * Method will check for beneficiary and its account
		 * val1 = for fetching saving account no
		 * val2 = for fetching current account no
		 * storeSavingBal = to store saving account balance
		 * storeCurrentBal = to store current account balance
		 * fname = will store beneficiary first name
		 * lname = will store beneficiary last name
		 * flagSavingBal = will check beneficiary saving balance
		 * flagCurrentBal = will check beneficiary current balance
		 */
		String val1="",val2="",Decision="",storeSavingBal="",storeCurrentBal="",fname="",lname="";
		File file =  new File(filename);
		User u = new User();
		if(file.exists())
		{
			Scanner in = new Scanner(file);
			String filecontents="";
			//fetching user data from file
			while(in.hasNext())
			{
				filecontents = filecontents + in.nextLine() + "\n";
			}
			in.close();
			String[] strlist = filecontents.split("\n");
			int flagSavingBal=0,flagCurrentBal=0;
			for (String str : strlist)
			{
				if(str.startsWith("First Name : "))
				{
					String[] name = str.split(":");
					fname = name[1];
				}
				if(str.startsWith("Last Name : "))
				{
					String[] name = str.split(":");
					lname = name[1];
				}
				if(str.startsWith("Savings Account no :"))
				{
					val1 = finddigit(str);
					if(val1.equals(beneficiaryAccNo))
					{
						flag=1; 
						flagSavingBal=1;
					}
				}
				if(str.startsWith("Current Account no :"))
				{
					 val2 = finddigit(str);
					 if(val2.equals(beneficiaryAccNo))
					 {
						 flag=1;
						 flagCurrentBal=1;
					 }
				}
				if(str.startsWith("Saving Account Balance :"))
				{
					if(flagSavingBal==1 && Integer.parseInt(val1)!=0)
					{
						storeSavingBal = str;
					}
				}
				if(str.startsWith("Current Account Balance :"))
				{
					if(flagCurrentBal==1 && Integer.parseInt(val2)!=0)
					{
						storeCurrentBal = str;
					}
				}
			
			}
			if(flagSavingBal==1)
			{
				Decision = JOptionPane.showInputDialog("--------Beneficiary User Details---------"
						+"\n Name : "+(fname+" "+lname)
						+"\n Account no : "+ val1
						+"\n Press Y To continue transaction..."
						+"\n Press X To abort transaction...");
				if(Decision.equalsIgnoreCase("y"))
				{
					drawMoney(user_id);
					u.Update(user_id, storeSavingBal,TransferAmount, "Saving Account Balance :","deposit");
					JOptionPane.showMessageDialog(null,"Money Tansfer Successfull");
				}else {
					JOptionPane.showMessageDialog(null,"Money Tansfer Transaction Aborted");
				}
			}
			if(flagCurrentBal==1)
			{
				Decision = JOptionPane.showInputDialog("--------Beneficiary User Details---------"
						+"\n Name : "+(fname+" "+lname)
						+"\n Account no : "+val2
						+"\n Press Y To continue transaction..."
						+"\n Press X To abort transaction...");
				if(Decision.equalsIgnoreCase("y"))
				{
					drawMoney(user_id);
					u.Update(user_id, storeCurrentBal,TransferAmount, "Current Account Balance :","deposit");
					JOptionPane.showMessageDialog(null,"Money Tansfer Successfull");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Money Tansfer Transaction Aborted");
				}
			}
		}
	}
	private static void drawMoney(String User_id) throws IOException {
		/**
		 * This function It will draw money from the user account
		 * 
		 * val1 = for fetching saving account no
		 * val2 = for fetching current account no
		 * storeSavingBal = to store saving account balance
		 * storeCurrentBal = to store current account balance
		 * charge_fee = fee charged while withdrawing
		 * flagSavingBal = will check if user savings account is created or not (0 = no and 1 = yes)
		 * flagCurrentBal = will check if user current account is created or not (0 = no and 1 = yes)
		 * debitAmount = store debit amount that user will enter 
		 */
		
		String val1="",val2="",storeSavingBal="",storeCurrentBal="";
		int charge_fee = 3;
		File file =  new File(User_id);
		User u = new User();
		if(file.exists())
		{
			Scanner in = new Scanner(file);
			String filecontents="";
			//fetching user data from file
			while(in.hasNext())
			{
				filecontents = filecontents + in.nextLine() + "\n";
			}
			in.close();
			String[] strlist = filecontents.split("\n");
			int flagSavingBal=0,flagCurrentBal=0;
			for (String str : strlist)
			{
				if(str.startsWith("Savings Account no :"))
				{
					val1 = finddigit(str);
					 if(Integer.parseInt(val1)!=0)
					 {
						 flagSavingBal=1;
					 }
				}
				if(str.startsWith("Current Account no :"))
				{
					 val2 = finddigit(str);
					 if(Integer.parseInt(val2)!=0)
					 {
						 flagCurrentBal=1;
					 }
				}
				if(str.startsWith("Saving Account Balance :"))
				{
					if(flagSavingBal==1)
					{
						storeSavingBal=finddigit(str);
					}
				}
				if(str.startsWith("Current Account Balance :"))
				{
					if(flagCurrentBal==1)
					{
						storeCurrentBal=finddigit(str);
					}
				}
			}
			//Below if statement will be executed if user has created both account types
			if(Integer.parseInt(val1)!=0 && Integer.parseInt(val2)!=0)
			{
				String choice = JOptionPane.showInputDialog("Enter 1. To debit from Savings Account\nEnter 2. To debit from Current Account");
				if(Integer.parseInt(choice)==1)
				{
					int flag=1;
					int amount=0;
					String debitAmount="";
					while(flag==1)
					{
						 debitAmount= JOptionPane.showInputDialog("Enter debit amount");
						 amount = Integer.parseInt(debitAmount);
						if(amount <= Integer.parseInt(storeSavingBal))
						{
							flag=0;
							amount = Integer.parseInt(debitAmount)+ charge_fee;
							debitAmount = String.valueOf(amount);
							TransferAmount = debitAmount;
							amount-=3;
							u.Update(User_id, storeSavingBal, debitAmount,"Saving Account Balance :", "debit");
							JOptionPane.showMessageDialog(null,"You Successfully Withdraw : $"+String.valueOf(amount));
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter Valid Amount");
						}
					}
					
					
				}
				else if(Integer.parseInt(choice)==2)
				{
					int flag=1;
					int amount=0;
					String debitAmount="";
					while(flag==1)
					{
						 debitAmount= JOptionPane.showInputDialog("Enter debit amount");
						 amount = Integer.parseInt(debitAmount);
						if(amount <= Integer.parseInt(storeCurrentBal))
						{
							flag=0;
							amount = Integer.parseInt(debitAmount)+ charge_fee;
							debitAmount = String.valueOf(amount);
							TransferAmount = debitAmount;
							amount-=3;
							u.Update(User_id, storeCurrentBal, debitAmount,"Current Account Balance :", "debit");
							JOptionPane.showMessageDialog(null,"You Successfully Withdraw : $"+String.valueOf(amount));
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter Valid Amount");
						}
					}
					
					
				}
			}
			//Below else if statement will be executed if user has only saving account and therefore only Saving account withdrawal is done
			else if(Integer.parseInt(storeSavingBal)!=0)
			{
					int flag=1;
					int amount=0;
					String debitAmount="";
					while(flag==1)
					{
						 debitAmount= JOptionPane.showInputDialog("Enter debit amount");
						 amount = Integer.parseInt(debitAmount);
						if(amount <= Integer.parseInt(val1))
						{
							flag=0;
							amount = Integer.parseInt(debitAmount)+ charge_fee;
							debitAmount = String.valueOf(amount);
							TransferAmount = debitAmount;
							amount-=3;
							u.Update(User_id, storeSavingBal, debitAmount,"Savings Account no :", "debit");
							JOptionPane.showMessageDialog(null,"You Successfully Withdraw : $"+String.valueOf(amount));
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter Valid Amount");
						}
					}
					
			}
			////Below else if statement will be executed if user has only current account and therefore only current account withdrawal is done
			else if(Integer.parseInt(storeCurrentBal)!=0)
			{
				int flag=1;
				int amount=0;
				String debitAmount="";
				while(flag==1)
				{
					 debitAmount= JOptionPane.showInputDialog("Enter debit amount");
					 amount = Integer.parseInt(debitAmount);
					if(amount <= Integer.parseInt(val1))
					{
						flag=0;
						amount = Integer.parseInt(debitAmount)+ charge_fee;
						debitAmount = String.valueOf(amount);
						TransferAmount = debitAmount;
						amount-=3;
						u.Update(User_id, storeCurrentBal, debitAmount,"Current Account no :", "debit");
						JOptionPane.showMessageDialog(null,"You Successfully Withdraw : $"+String.valueOf(amount));
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Valid Amount");
					}
				}
				
			}
		}
	}

	private static void checkAccount(String User_id) throws IOException {
		/**
		 * Method will help user to create another account type (like Saving or current if not created at the time of register).
		 * object.Account_creation = will create another account for that user
		 */
		
		User u = new User();
		u.Account_creation(User_id);
		
	}

	private static void depositMoney(String User_id) throws IOException {
		/**Method will help user to deposit a money in his accounts.
		 * 
		 * val1=store user saving account no
		 * val2 = store user current account no
		 * storeSavingBal = store user saving account balance
		 * storeCurrentBalance = store user current account balance
		 * filecontents = store user data which is fetched from file.
		 * creditAmount = store credit amount that user will enter.
		 */
		String val1="",val2="",storeSavingBal="",storeCurrentBal="";
		File file =  new File(User_id);
		User u = new User();
		if(file.exists())
		{
			Scanner in = new Scanner(file);
			String filecontents="";
			while(in.hasNext())
			{
				filecontents = filecontents + in.nextLine() + "\n";
			}
			in.close();
			String[] strlist = filecontents.split("\n");
			int flagSavingBal=0,flagCurrentBal=0;
			for (String str : strlist)
			{
				if(str.startsWith("Savings Account no :"))
				{
					val1 = finddigit(str);
					 if(Integer.parseInt(val1)!=0)
					 {
						 flagSavingBal=1;
					 }
				}
				if(str.startsWith("Current Account no :"))
				{
					 val2 = finddigit(str);
					 if(Integer.parseInt(val2)!=0)
					 {
						 flagCurrentBal=1;
					 }
				}
				if(str.startsWith("Saving Account Balance :"))
				{
					if(flagSavingBal==1)
					{
						storeSavingBal=finddigit(str);
					}
				}
				if(str.startsWith("Current Account Balance :"))
				{
					if(flagCurrentBal==1)
					{
						storeCurrentBal=finddigit(str);
					}
				}
			}
			if(Integer.parseInt(val1)!=0 && Integer.parseInt(val2)!=0)
			{
				String choice = JOptionPane.showInputDialog("Enter 1. To Deposit in Savings Account\nEnter 2. To Deposit in Current Account");
				//saving account deposit
				if(Integer.parseInt(choice)==1)
				{
					int amount=0;
					String creditAmount="";
						 	creditAmount= JOptionPane.showInputDialog("Enter credit amount");
							u.Update(User_id, storeSavingBal, creditAmount,"Saving Account Balance :", "deposit");
							amount = Integer.parseInt(storeSavingBal)+Integer.parseInt(creditAmount);
							JOptionPane.showMessageDialog(null,"You Successfully deposited \n Current Balance is : $"+String.valueOf(amount));
	
				}
				//current account deposit
				else if(Integer.parseInt(choice)==2)
				{
					int amount=0;
					String creditAmount="";
						 creditAmount= JOptionPane.showInputDialog("Enter credit amount");
						 amount = Integer.parseInt(creditAmount) + Integer.parseInt(storeCurrentBal);
						u.Update(User_id, storeCurrentBal, creditAmount,"Current Account Balance :", "deposit");
						JOptionPane.showMessageDialog(null,"You Successfully deposited \n Current Balance is : $"+String.valueOf(amount));
				}
			}
			//Saving account deposit
			else if(Integer.parseInt(storeSavingBal)!=0)
			{
					int amount=0;
					String creditAmount="";
						 creditAmount= JOptionPane.showInputDialog("Enter credit amount");
						 amount = Integer.parseInt(creditAmount)+Integer.parseInt(storeSavingBal);
							u.Update(User_id, storeSavingBal, creditAmount,"Savings Account no :", "deposit");
							JOptionPane.showMessageDialog(null,"You Successfully deposited \n Current Balance is : $"+String.valueOf(amount));
					
			}
			//current account deposit
			else if(Integer.parseInt(storeCurrentBal)!=0)
			{
				int amount=0;
				String creditAmount="";
					 creditAmount= JOptionPane.showInputDialog("Enter credit amount");
					 amount = Integer.parseInt(creditAmount)+Integer.parseInt(storeCurrentBal);
						u.Update(User_id, storeCurrentBal, creditAmount,"Current Account no :", "deposit");
						JOptionPane.showMessageDialog(null,"You Successfully deposited \n Current Balance is : $"+String.valueOf(amount));
				
			}
		}
	}

	private static String finddigit(String line) {
		/**
		 * Method will check the digits in string and return the string of digits if found.
		 */
		StringBuilder sb= new StringBuilder();
		char[] arr = line.toCharArray();
		for(char ch : arr)
		{
			if(Character.isDigit(ch))
			{
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	private static void checkBalance(String uid) throws IOException {
		/**
		 * Method allows user to check their balance.
		 * val1  = store user saving account no
		 * val2 = store user current account no
		 * sb = store user saving account balance
		 * cb = store user current account balance
		 * filecontents = fetchs all user data from file 
		 */
		String val1="",val2="",sb="",cb="";
		int savingBal=0,currentBal=0;
		File file = new File(uid);
		if(file.exists())
		{
			Scanner in = new Scanner(file);
			String filecontents="";
			while(in.hasNext())
			{
				filecontents = filecontents +in.nextLine()+ "\n";
			}
			in.close();
			String[] strlist = filecontents.split("\n");
			for (String str : strlist)
			{
				if(str.startsWith("Savings Account no :"))
				{
					val1 = finddigit(str);
					if(Integer.parseInt(val1)!=0)
					{
						savingBal = 1;
					}
					
				}
				if(str.startsWith("Current Account no :"))
				{
					 val2 = finddigit(str);
					 if(Integer.parseInt(val2)!=0)
					 {
						 currentBal=1;
					 }
					 
				}
				if(savingBal==1)
				{
					if((str).startsWith("Saving Account Balance"))
					{
						sb = str;
					}
				}
				if(currentBal==1)
				{
					if((str).startsWith("Current Account Balance"))
					{
						cb = str;
					}
				}
			}
			if(Integer.parseInt(val1)!=0 && Integer.parseInt(val2)!=0)
			{
				String choice = JOptionPane.showInputDialog("Enter 1. To View Savings Account Balance\nEnter 2. To View Current Account Balance");
				if(Integer.parseInt(choice)==1)
				{
					JOptionPane.showMessageDialog(null, sb);
				}
				if(Integer.parseInt(choice)==2)
				{
					JOptionPane.showMessageDialog(null, cb);
				}
			}
			else if(Integer.parseInt(val1)!=0)
			{
				JOptionPane.showMessageDialog(null, sb);
			}
			else if(Integer.parseInt(val2)!=0)
			{
				JOptionPane.showMessageDialog(null, cb);
			}	
		}
	}

}
