package test;
import java.util.Scanner;

import LibraryDao.userDao;
import pojo.*;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void acceptRecord(Person person)
	{
		System.out.print("Enter User's Name	  :	");
		person.setUsers_name(sc.nextLine());
		sc.nextLine();
		System.out.print("Enter User's Email	:	");
		person.setUsers_email(sc.nextLine());
		sc.nextLine();
		System.out.print("Enter User's Phone    :	");
		person.setUsers_phone(sc.nextInt());
		System.out.print("Enter User's Password :	");
		person.setUsers_passwd(sc.nextLine());
		sc.nextLine();
		System.out.print("Enter User's Role	  :	 ");
		person.setUsers_role(sc.nextLine());
		sc.nextLine();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("0.Exit");
		System.out.println("1.Sign Up");
		System.out.println("2.Sign in");
		System.out.println("Enter a choice:");
		int choice=sc.nextInt();
		while(choice!=0)
		{
			switch(choice)
			{
			case 1:Person p=new Person();
				acceptRecord(p);
			case 2:
			}
		}
		
		
	
	}
	
	
}
