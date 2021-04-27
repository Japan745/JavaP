/**
 * 
 */
package javaProject;

import java.io.File;
//import User.java;
import java.io.IOException;
import java.util.ArrayList;
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int options;
		String uid="";
		do {
			options =Integer.parseInt(JOptionPane.showInputDialog("Enter 1. If you are a existing User.\r\n "
			+ "Enter 2. If you are a new User.\r\n"
			+ "Enter 0. Exit\n"));
			if(options!=0 && options!=2)
				uid = JOptionPane.showInputDialog("Enter your user id");
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
						drawMoney();
					}
					else if(choice==4)
					{
						moneyTransfer();
					}
					else if(choice==5)
					{
						payUtilityBills();
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
				}
			}
			else if(options==2) 
			{
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

	private static void editDetails(String uid) throws IOException {
		// TODO Auto-generated method stub
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
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter First Name\n");
				String type =  "First Name";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "First Name Updated Successfully");
			}else if(edit==2)
			{
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Last Name\n");
				String type =  "Last Name";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Last Name Updated Successfully");
				
			}else if(edit==3)
			{
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Date of Birth\n");
				String type =  "DOB";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Date of Birth Updated Successfully");
				
			}else if(edit==4)
			{
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Contact no\n");
				String type =  "Contact no";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Contact no Updated Successfully");
				
			}else if(edit==5)
			{
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new SIN no\n");
				String type =  "SIN no";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "SIN no Updated Successfully");
			}
			else if(edit==6)
			{
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Address\n");
				String type =  "Address";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Address Updated Successfully");
			}
			else if(edit==7)
			{
				File update = new File(uid);
				User u = new User();
				String newvalue = JOptionPane.showInputDialog("Enter new Email\n");
				String type =  "Email";
				//String startwith =  "First Name";
				u.Update(uid, newvalue, newvalue, type, type);
				JOptionPane.showMessageDialog(null, "Email Updated Successfully");
			}
		}while(edit!=0);
	}

	private static void viewDetails(String uid) throws IOException {
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

	private static void payUtilityBills() {
		// TODO Auto-generated method stub
		
	}

	private static void moneyTransfer() {
		// TODO Auto-generated method stub
		
	}

	private static void drawMoney() {
		// TODO Auto-generated method stub
		
	}

	private static void checkAccount(String User_id) throws IOException {
		// TODO Auto-generated method stub
		
		
		User u = new User();
		u.Account_creation(User_id);
		
	}

	private static void depositMoney(String uid) {
		// TODO Auto-generated method stub
		try {
			File file = new File(uid);
			Scanner in = new Scanner(file);
			while(in.hasNext())
			{
				String line = in.nextLine();
				if(line.startsWith("Saving Account Balance"))
				{
					String str = finddigit(line);
					JOptionPane.showMessageDialog(null, line);
					String value = JOptionPane.showInputDialog("Enter your deposit Value");
					User u = new User();
					File check = new File(uid);
					if(check.exists())
					{
						String startwith = "Saving Account Balance";
						String type="deposit";
						u.Update(uid,str, value,startwith,type);
					}
					
				}
			}
			in.close();
		}catch(IOException IE)
		{
			
		}
	}

	private static String finddigit(String line) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();
		char[] arr = line.toCharArray();
		int i=0;
		/*while(i < arr.length)
		{
			if(Character.isDigit(arr[i]))
			{
				sb.append(arr[i]);
			}
		}*/
		for(char ch : arr)
		{
			if(Character.isDigit(ch))
			{
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	private static void checkBalance(String uid) {
		// TODO Auto-generated method stub
		try {
			File file = new File(uid);
			Scanner in = new Scanner(file);
			while(in.hasNext())
			{
				String line = in.nextLine();
				if((line).startsWith("Saving Account Balance"))
				{
					JOptionPane.showMessageDialog(null, line);
				}
			}
			in.close();
			
		}catch(IOException IE)
		{
			System.out.println(IE);
		}
	}

}
