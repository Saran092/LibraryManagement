public class studentList{
	
	String Id;
	String studentName;

	studentList(String Id,String name)
	{
		this.Id = Id;
		studentName = name;
	}
	public String getId(){
		return Id;
	}
	public String getName(){
		return studentName;
	}

	public String toString()
	{
		return String.format("%-20s%-20s",Id,studentName);
	}

	studentList(){};
}