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
		List <bookList> Rlist = new ArrayList<>();
		int choice,insideChoice,count;
		String name,bookName,id,isbn;
		boolean status= false;
		do{
			System.out.println("1.Student Details\n2.Book Details\n3.Search Book\n4.Check Out the Book\n5.Display the Check out Details\n6.Returned Book Back\n7.Returned Details\n8.Exit");
			System.out.print("Enter Your Choice:");
			choice = Sc.nextInt();
			switch(choice)
			{
				case 1:
					do{
						System.out.println("1.Add Student\n2.Display Student List\n3.Exit");
						insideChoice = Sc.nextInt();
						switch(insideChoice)
						{
							case 1:
								Sc.nextLine();
								System.out.println("Enter Student ID:");
								id = Sc.nextLine();
								System.out.println("Enter Student Name:");
								name = Sc.nextLine();
								studentList st = new studentList(id,name);
								StDt.add(st);
								System.out.println("\nStudent Add Successfully");
								break;
							case 2:
								System.out.println("Student List");
								System.out.printf("%-20s%-20s\n","ID","Name");
								for(studentList list: StDt)
									System.out.println(list);
								break;
							case 3:
								System.out.println("Exit...");
								break;
							default:
								System.out.println("Invalid Choice Try Again");
								break;
						}
						}while(insideChoice!=3);
					
					break;
			case 2:
				do{
						System.out.println("1.Add Book\n2.Display Book List \n3.Display the Check Out Book List\n4.Display the Available Book List\n%5.Exit");
						insideChoice = Sc.nextInt();
						switch(insideChoice)
						{
							case 1:
								Sc.nextLine();
								System.out.println("Enter ISBN Book Id:");
								isbn = Sc.nextLine();
								System.out.println("Enter Book Name:");
								bookName = Sc.nextLine();
								bookList bk = new bookList(isbn,bookName);
								BkDt.add(bk);
								System.out.println("\nBook Add Successfully");
								break;
							case 2:
								System.out.println("\nBook List");
								System.out.printf("%-20s%-20s\n","ISBN","BookName");
								for(bookList list: BkDt)
									System.out.println(list);
								break;
							case 3:
								System.out.println("Check Out Details: ");
								System.out.printf("%-20s%-20s%-20s\n","Student ID","Student Name","BookName");
								for(bookList list: borrow)
									System.out.println(list.formatOutput("BorrowDetails"));
								break;
							case 4:
								System.out.println("\nAvaliable Books: ");
								System.out.printf("%-20s%-20s\n","ISBN","BookName");
								for(bookList list: BkDt)
									System.out.println(list);
								break;
							case 5: 
								System.out.println("Exit");
								break;
							default:
								System.out.println("Invalid Choice Try Again..");
								break;
						}
					}while(insideChoice!=5);
				
			case 3:
				
				Sc.nextLine();
				System.out.println("Search..");
				System.out.println("Enter the Book Name to Search:");
				bookName = Sc.nextLine();
				for(bookList Sch : BkDt)
				{
					if(Sch.getName().equals(bookName))
					{
						System.out.println("Book Available..");
					}
				}
				break;

			case 4:
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
								status = true;
								bookList br = new bookList(id,bookName,sch.getName());
								borrow.add(br);
								System.out.println("Book Borrow Successfully..");
							}
							// else
								// System.out.println("No Book Available..");
						}
					}
					else{
						System.out.println("No Student Id Available..");
						break;
					}
					if(!status)
						System.out.println("No Book Available..");
				}
				break;
			case 5:
				System.out.println("Check Out Details: ");
				System.out.printf("%-20s%-20s%-20s\n","Student ID","Student Name","BookName");
				for(bookList list: borrow)
					System.out.println(list.formatOutput("BorrowDetails"));
				break;
			case 6:
				Sc.nextLine();
				System.out.println("Enter the Student Id:");
				id = Sc.nextLine();
				System.out.println("Enter the Book Name:");
				bookName = Sc.nextLine();

				Iterator<bookList> iterator = borrow.iterator();
				while (iterator.hasNext()) {
					bookList bor = iterator.next();
			        if (bor.getId().equals(id) && bor.getName().equals(bookName)) {
			        	bookList rbook = new bookList(id,bookName,bor.getName());
			        	Rlist.add(rbook);
			            iterator.remove(); 
			            System.out.println("Book Returned Successfully..");
			            break;
			        }
				}
				break;
			case 7:
				System.out.println("Returned Details...");
				System.out.printf("%-20s%-20s%-20s\n","Student ID","Student Name","BookName");
				for(bookList list: Rlist)
					System.out.println(list.formatOutput("BorrowDetails"));
				break;
			case 8:
				System.out.println("Exit...");
				break;
			default:
				System.out.println("Invalid Choice Try Again");
				break;
			}
		}while(choice!=8);
	}
}