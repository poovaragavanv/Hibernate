package xml;

import java.util.HashSet;

public class TestInsertStudent {
	public static void main(String arg[]) {

		StudentDao m = new StudentDao();
		Student v = new Student();
		v.setStudentName("supparayan");
		Phone c1 = new Phone();
		c1.setPhoneNumber("9877787973");
		c1.setPhoneType("mobile");
		Phone c2 = new Phone();
		c2.setPhoneNumber("23455555");
		c2.setPhoneType("house");
		HashSet<Phone> s = new HashSet<Phone>();

		s.add(c1);
		s.add(c2);
		v.setStudentPhone(s);
		m.insertStudent(v);

	}

}
