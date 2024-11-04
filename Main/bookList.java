public class bookList {
	String ISBN;
	String bookName;
	String studentName;

	bookList(String id,String name){
		ISBN = id;
		bookName = name; 
	}

	bookList(String id,String name,String stName){
		ISBN = id;
		bookName = name;
		studentName = stName; 
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

	public String formatOutput(String type) {
        switch (type) {
            case "BorrowDetails":
                return String.format("%-20s%-20s%-20s",ISBN,studentName,bookName);
            case "detailed":
                return String.format("%-20s%-20s",ISBN,bookName);
            default:
                return toString();
        }
    }
	
}