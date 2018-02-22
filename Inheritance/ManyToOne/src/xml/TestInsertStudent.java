package xml;

public class TestInsertStudent {
	public static void main(String arg[]) {
		try {
			StudentDao m = new StudentDao();
			Address ad = new Address();
			ad.setCity("chennai");
			ad.setState("TN");
			ad.setStreet("middle");
			ad.setZipcode("123456");

			Student c1 = new Student();

			c1.setStudentName("mani");
			c1.setStudentAddress(ad);

			Student c2 = new Student();

			c2.setStudentName("raja");
			c2.setStudentAddress(ad);

			m.insertStudent(c1);
			m.insertStudent(c2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
