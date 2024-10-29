public class bookList {
	String ISBN;
	String bookName;

	bookList(String id,String name){
		ISBN = id;
		bookName = name; 
	}

	public String getId(){
		return ISBN;
	}
	public String getName(){
		return bookName;
	}

	bookList(){};

	public String toString()
	{
		return String.format("%-20s%-20s",ISBN,bookName);
	}
}