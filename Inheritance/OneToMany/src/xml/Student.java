package xml;

import java.util.Set;

public class Student {

	private long studentId;
	private String studentName;
	private Set<Phone> studentPhone;

	public Set<Phone> getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(Set<Phone> studentPhone) {
		this.studentPhone = studentPhone;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
