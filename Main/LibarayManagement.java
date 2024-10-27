import java.util.*;
class LibarayManagement{
	public static void main(String args[])
	{
		Scanner Sc = new Scanner(System.in);
		studentList obj = new studentList();
		List <studentList> StDt = new ArrayList<>();
		int id,isbn,choice;
		String name,bookName;
		do{
			System.out.println("1.Add Student\n2.Display Student\n3.Add Book\n4.Display Book");
			System.out.print("Enter Your Choice:");
			choice = Sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Student ID:");
				id = Sc.nextInt();
				Sc.nextLine();
				System.out.println("Enter Student Name:");
				name = Sc.nextLine();
				studentList st = new studentList(id,name);
				StDt.add(st);
				System.out.println("Student Add Successfully");
				break;
			case 2:
				System.out.printf("%-20s%-20s\n","ID","Name");
				for(studentList list: StDt)
					System.out.println(list);
			}
		}while(choice!=3);
	}
}