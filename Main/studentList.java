public class studentList{
	
	int Id;
	String studentName;

	studentList(int Id,String name)
	{
		this.Id = Id;
		studentName = name;
	}
	public String toString()
	{
		return String.format("%-20s%-20s",Id,studentName);
	}

	studentList(){};
}