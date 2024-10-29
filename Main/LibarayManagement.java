import java.util.*;
class LibarayManagement{
	public static void main(String args[])
	{
		Scanner Sc = new Scanner(System.in);
		studentList obj = new studentList();
		bookList obj1 = new bookList();
		List <studentList> StDt = new ArrayList<>();
		List <bookList> BkDt = new ArrayList<>();
		List <bookList> borrow = new ArrayList<>();
		int choice;
		String name,bookName,id,isbn;
		do{
			System.out.println("1.Add Student\n2.Display Student\n3.Add Book\n4.Display Book\n5.Borrow Book From Libaray\n6.Display Borrowed Book");
			System.out.print("Enter Your Choice:");
			choice = Sc.nextInt();
			switch(choice)
			{
			case 1:
				Sc.nextLine();

				System.out.println("Enter Student ID:");
				id = Sc.nextLine();
				// Sc.nextLine();
				System.out.println("Enter Student Name:");
				name = Sc.nextLine();
				studentList st = new studentList(id,name);
				StDt.add(st);
				System.out.println("\nStudent Add Successfully");
				break;
			case 2:
				System.out.printf("%-20s%-20s\n","ID","Name");
				for(studentList list: StDt)
					System.out.println(list);
				break;
			case 3:
				Sc.nextLine();
				System.out.println("Enter ISBN Book Id:");
				isbn = Sc.nextLine();
				// Sc.nextLine();
				System.out.println("Enter Book Name:");
				bookName = Sc.nextLine();
				bookList bk = new bookList(isbn,bookName);
				BkDt.add(bk);
				System.out.println("\nBook Add Successfully");
				break;
			case 4:
				System.out.printf("%-20s%-20s\n","ISBN","BookName");
				for(bookList list: BkDt)
					System.out.println(list);
				break;
			case 5:
				Sc.nextLine();

				System.out.println("Enter the Student Id:");
				id = Sc.nextLine();
				// Sc.nextLine();
				System.out.println("Enter the Book Name:");
				bookName = Sc.nextLine();
				for(studentList sch : StDt){
					if(sch.getId().equals(id))
					{
						for(bookList bch : BkDt){
							if(bch.getName().equals(bookName))
							{
								bookList br = new bookList(id,bookName);
								borrow.add(br);
							}
							else
								System.out.println("No Book Available..");
						}
					}
					else
						System.out.println("No Student Id Available..");
				}
				break;
			case 6:
				System.out.println("Borrow Detals: ");
				System.out.printf("%-20s%-20s\n","Student ID","BookName");
				for(bookList list: borrow)
					System.out.println(list);
				break;
			default:
				System.out.println("Exit...");
				break;
			}
		}while(choice!=7);
	}
}