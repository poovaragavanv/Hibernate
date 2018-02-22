package xml;
public class Student 
{

	private long studentId;
	private String studentName;
	private Address studentAddress;

	public Student() 
	{
	}

	public Student(String studentName, Address studentAddress) 
	{
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public Address getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

}
