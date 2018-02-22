package xml;

import java.util.Iterator;
import java.util.Set;

public class TestGetStudent {
	public static void main(String arg[]) {
		StudentDao ms = new StudentDao();

		Student st = ms.getStudent(2);
		Set<Phone> sts = st.getStudentPhone();
		System.out.println(st.getStudentName());

		Iterator<Phone> co = sts.iterator();
		while (co.hasNext()) {
			Phone cr = (Phone) co.next();
			System.out.println(cr.getPhoneNumber());
			System.out.println(cr.getPhoneType());
		}

	}

}
