package Controller;
import java.io.IOException;
import java.util.Scanner;
import dto.Student;

import Service.IStudentService;
import Service_Factory.StudentServiceFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestApp {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			
			case 1: insertQuery();
			        break;
			 
			case 2: selectQuery();
			        break;
			
			case 3: updateQuery();
			        break;
			
			case 4: deleteQuery();
			        break;
			        
			case 5: System.out.println("Thank you using my app...");
			         System.exit(0);
			
			default: System.out.println("Invalid option better to try next time with valid option...");
			          break;
			         
			}
		}
		
		
		
		
}








	private static void selectQuery() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id of the record which you want to see: ");
		int id = scan.nextInt();
		Student std = studentService.searchStudent(id);
		if(std != null) {
			System.out.println("[id="+std.getSid()+", name="+std.getSname()+", age="+std.getSage()+", address"+std.getSaddress()+"]");
		}
		else
			System.out.println("There is no such record is present...");
	}








	private static void updateQuery() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the id for which correspoding record you want to update");
		int id = Integer.parseInt(br.readLine());
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(id);
		Student std2 = new Student();
		if(std != null) {
			std2.setSid(std.getSid());
			System.out.println("The old name of student in record is: "+std.getSname()+" Enter the new name: ");
			String newName = br.readLine();
			if(newName.equals("") || newName == "")
				std2.setSname(std.getSname());
			else
				std2.setSname(newName);
			
			
			System.out.println("The old age of student in record is: "+std.getSage()+" Enter the new age: ");
			String newAge = br.readLine();
			if(newAge.equals("") || newAge == "")
				std2.setSage(std.getSage());
			else
				std2.setSage(Integer.parseInt(newAge));
			
			
			System.out.println("The old address of student in record is: "+std.getSage()+" Enter the new address: ");
			String newAddress = br.readLine();
			if(newAddress.equals("") || newAddress == "")
				std2.setSaddress(std.getSaddress());
			else
				std2.setSaddress(newAddress);
			
			String msg = studentService.updateStudent(std2);
			if(msg.equalsIgnoreCase("success"))
				System.out.println("row successfully updated...");
			else
				System.out.println("unable to update the row due to some internal issue...");
			
		}
		else {
			System.out.println("Sorry there is no such Id is present for which you want to make a updation operation to be done...");
		}
	}





	
	

	private static void deleteQuery() {
		Scanner scan = new Scanner(System.in);
		  System.out.println("Enter the id...");
		  int id = scan.nextInt();
		  IStudentService studentService = StudentServiceFactory.getStudentService();
		  String msg = studentService.deleteStudent(id);
		  if(msg.equalsIgnoreCase("successfull")) {
			  System.out.println("successfull in deleting");
		  }
		  else if(msg.equalsIgnoreCase("unsuccessfull")) {
			  System.out.println("There is no such id present");
		  }
		  else {
			  System.out.println("unsuccesfull in deleting...");
		  }
	}

	private static void search() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scan.nextInt();
		Student s = studentService.searchStudent(id);
        if(s != null) {
        	System.out.println(s);
        	System.out.println("ID\tNAME\tAGE\tADDRESS");
        	System.out.println(s.getSid()+"\t"+s.getSname()+"\t"+s.getSage()+"\t"+s.getSaddress());
        }
        else {
        	System.out.println("No records available");
        }
	}

	private static void insertQuery() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = scan.next();
		System.out.println("Enter the age");
		int age = scan.nextInt();
		System.out.println("Enter Address");
		String address = scan.next();
		String msg = studentService.addStudent(name,age,address);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}
	}
}