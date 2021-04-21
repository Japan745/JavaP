/**
 * 
 */
package javaProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * @author Japan Patel
 *
 */
public class User {

	/**
	 * @param args
	 */
	//variable declarations
	private String Fname,Lname,Address,DOB,Email;
	private int User_id,Savings_Account, Current_Account,Saving_Account_Balance,Current_Account_Balance,Credit,Debit;
	private long SIN_no,Contact_no;
	//constructor.
	public User() 
	{
		this.Fname="";
		this.Lname="";
		this.Address="";
		this.DOB="";
		this.Email="";
		this.User_id=0;
		this.SIN_no=0;
		this.Contact_no=0;
		this.Savings_Account=0;
		this.Current_Account=0;
		this.Saving_Account_Balance=0;
		this.Current_Account_Balance=0;
	}
	public User(String Fname,String Lname,String Address, String DOB, String Email,long Contact_no, long SIN_no) 
	{
		this.Fname=Fname;
		this.Lname=Lname;
		this.Address=Address;
		this.DOB=DOB;
		this.Email=Email;
		this.User_id= (int) Math.round(Math.random()*1000000);
		this.SIN_no=SIN_no;
		this.Contact_no=Contact_no;
		this.Savings_Account=0;
		this.Current_Account=0;
		this.Saving_Account_Balance=0;
	}
	//Getter methods for variables
	public String getFname() {
		return Fname;
	}
	public String getLname() {
		return Lname;
	}
	public String getAddress() {
		return Address;
	}
	public String getDOB() {
		return DOB;
	}
	public String getEmail() {
		return Email;
	}
	public int getUser_id() {
		return User_id;
	}
	public long getSIN_no() {
		return SIN_no;
	}
	public long getContact_no() {
		return Contact_no;
	}
	public int getSavings_Account() {
		return Savings_Account;
	}
	public int getCurrent_Account() {
		return Current_Account;
	}
	public int getSaving_Account_Balance() {
		return Saving_Account_Balance;
	}
	public int getCurrent_Account_Balance() {
		return Current_Account_Balance;
	}
	public int getCredit() {
		return Credit;
	}
	public int getDebit() {
		return Debit;
	}
	//Setter methods for variable
	public void setFname(String Fname) {
		 this.Fname = Fname;
	}
	public void setLname(String Lname) {
		 this.Lname = Lname;
	}
	public void setAddress(String Address) {
		 this.Address = Address;
	}
	public void setDOB(String DOB) {
		 this.DOB = DOB;
	}
	public void setEmail(String Email) {
		 this.Email = Email;
	}
	public void setUser_id(int User_id) {
		 this.User_id = User_id;
	}
	public void setSIN_no(int SIN_no) {
		 this.SIN_no = SIN_no;
	}
	public void setContact_no(int Contact_no) {
		 this.Contact_no = Contact_no;
	}
	public void setSavings_Account(int Savings_Account) {
		 this.Savings_Account = Savings_Account;
	}
	public void setCurrent_Account(int Current_Account) {
		 this.Current_Account = Current_Account;
	}
	public void setSaving_Account_Balance(int Saving_Account_Balance) {
		 this.Saving_Account_Balance = Saving_Account_Balance;
	}
	public void setCurrent_Account_Balance(int Current_Account_Balance) {
		 this.Current_Account_Balance = Current_Account_Balance;
	}
	public void setCredit(int Credit) {
		 this.Credit = Credit;
	}
	public void setDebit(int Debit) {
		 this.Debit = Debit;
	}
	public void save() throws IOException
	{
		/**
		 * to the details of the user.
		 */
		File file = new File(String.valueOf(this.User_id));
		PrintWriter pw = new PrintWriter(file);
		pw.println("User ID : "+String.valueOf(this.User_id));
		pw.println("First Name : "+this.Fname);
		pw.println("Last Name : "+this.Lname);
		pw.println("Address : "+this.Address);
		pw.println("DOB : "+this.DOB);
		pw.println("Contact no : "+String.valueOf(this.Contact_no));
		pw.println("Savings Account no : "+String.valueOf(this.Savings_Account));
		pw.println("Current Account no : "+String.valueOf(this.Current_Account));
		pw.println("Saving Account Balance : "+String.valueOf(this.Saving_Account_Balance));
		pw.println("Current Account Balance : "+String.valueOf(this.Current_Account_Balance));
		pw.println("SIN no : "+String.valueOf(this.SIN_no));
		pw.close();
	}
	public void Update(String User_id,String OldValue, String NewValue, String startwith,String type) throws IOException 
	{
		/**
		 * to update the details of user in file
		 *
		 */
		File file = new File(User_id);
	      Scanner sc = new Scanner(file);
	      String fileContents="";
	      while(sc.hasNext())
	      {
	    	  fileContents = fileContents + sc.nextLine() +"\n";
	      }
	      String[] contentarr = fileContents.split("\n");
	      String newcontents="",uvalue="",val="";
	      int updatedValue=0;
	      for(String str : contentarr)
	      {
	    	  if(str.startsWith(startwith))
	    	  {
	    		  if(type.equals("deposit"))
	    		  {
	    			  val = findDigitValue(str);
	    			  updatedValue = Integer.parseInt(val) + Integer.parseInt(NewValue);
	    			  uvalue = String.valueOf(updatedValue);
	    		  }
	    		  else if(type.equals("debit"))
	    		  {
	    			  val = findDigitValue(str);
	    			  updatedValue = Integer.parseInt(val) - Integer.parseInt(NewValue);
	    			  uvalue = String.valueOf(updatedValue);
	    		  }
	    		  else if(type.equals("mobile"))
	    		  {
	    			  val = findDigitValue(str);
	    			  uvalue = NewValue;
	    		  }
	    		  else if(type.equals("sin"))
	    		  {
	    			  val = findDigitValue(str);
	    			  uvalue = NewValue;
	    		  }
	    		  else
	    		  {
	    			  String[] arr = str.split("[:]", 0);
	    			  val = arr[1];
	    			  uvalue = NewValue;
	    		  }
	    		  str = str.replace(val,uvalue);
	    		//  String val = findDigitValue(str);
	    		 // String uvalue = chooseType(type,);
	    		 // updatedValue = Integer.parseInt(val) + Integer.parseInt(NewValue);
	    		 // System.out.println("updated balance is : "+updatedValue);
	    		 // String uvalue = String.valueOf(updatedValue);
	    		  
	    		  //System.out.println("the updated value is :" + str);
	    		  //writer.append(str);
	    		  newcontents = newcontents + str + "\n";
	    	  }else {
	    		  //writer.append(str);
	    		  newcontents = newcontents + str + "\n";
	    	  }
	      }
	      sc.close();
	      file.delete();
	      File newfile = new File(User_id);
	      PrintWriter pw = new PrintWriter(newfile);
	      pw.println(newcontents);
	      pw.close();
	      if(type.equals("deposit"))
	      {
	    	  JOptionPane.showMessageDialog(null,"Deposited Successfully\n\nYour Saving Balance is :" +updatedValue);
	      }
	}
	private String chooseType(String type) {
		// TODO Auto-generated method stub
		
		return null;
	}
	private String findDigitValue(String fileData) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();
		char[] arr = fileData.toCharArray();
		for(char ch : arr)
		{
			if(Character.isDigit(ch))
			{
				sb.append(ch);
			}
		}
		//System.out.println("the digit is :"+sb.toString());
		return sb.toString();
	}
}
